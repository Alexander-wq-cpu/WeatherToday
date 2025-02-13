package ru.ilin.WeatherToday2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.ilin.WeatherToday2.TelegramBot.Bot;

@SpringBootApplication
public class WeatherToday2Application implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args){
		SpringApplication.run(WeatherToday2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
		Bot bot = context.getBean(Bot.class);
		telegramBotsApi.registerBot(bot);

//		RewriteDB rewriteDB = context.getBean(RewriteDB.class);
//		rewriteDB.rewrite();
	}
}
