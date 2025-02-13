package ru.ilin.WeatherToday2.TelegramBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.ilin.WeatherToday2.dto.Temperature;
import ru.ilin.WeatherToday2.service.CityService;

@Component
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;
    @Value("${weatherstack.access.key}")
    private String accessKey;

    private final CityService cityService;
    private final RestTemplate restTemplate;

    @Autowired
    public Bot(CityService cityService, RestTemplate restTemplate) {
        this.cityService = cityService;
        this.restTemplate = restTemplate;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            if (update.getMessage().isCommand()) {
                if (update.getMessage().getText().equals("/start"))
                    sendText(update, "Введите город на русском языке");
            }
            else {

                String city = update.getMessage().getText();
                if (checkCity(city))
                    sendText(update, getTemperature(city));
                else
                    sendText(update, "такого города нет в России");
            }
        }
    }

    public boolean checkCity(String city) {
        System.out.println(city);

        String lowerCaseCity = city.toLowerCase();

        if (cityService.getCityByName(lowerCaseCity).isPresent()) {
            System.out.println("такой город есть в России\n" +
                    getTemperature(lowerCaseCity));
            return true;
        } else {
            System.out.println("такого города нет в России");
            return false;
        }
    }

    public String getTemperature(String city) {
           ResponseEntity<Temperature> response = restTemplate.exchange("http://api.weatherstack.com/current\n" +
                   "?access_key=" + accessKey +
                   "&query=" + city,
                   HttpMethod.GET,
                   null,
                   new ParameterizedTypeReference<Temperature>() {
                   });
           return response.getBody().toString();
    }

    public void sendText(Update update, String message) {
        try{
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(message);
            sendMessage.setChatId(update.getMessage().getChatId());
            execute(sendMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
