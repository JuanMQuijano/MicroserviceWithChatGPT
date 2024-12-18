package com.example.GPTMicroservice;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GptMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GptMicroserviceApplication.class, args);
	}

	@Bean
	public ChatClient chatClient(ChatClient.Builder builder){
		return builder.build();
	}

}
