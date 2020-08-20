package com.example.consumer;

import com.example.consumer.controller.ConsumerControllerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeConsumerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeeConsumerApplication.class, args);
		ConsumerControllerClient consumerControllerClient = context.getBean(ConsumerControllerClient.class);
		System.out.println(consumerControllerClient);
		System.out.println(consumerControllerClient.toString());
		System.out.println(consumerControllerClient.getEmployee());

	}

	@Bean
	public ConsumerControllerClient consumerControllerClient(){
		return new ConsumerControllerClient();
	}

}
