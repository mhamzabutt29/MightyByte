package com.example.MightyByte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@ImportResource("classpath*:cucumber.xml")
public class MightyByteApplication {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("C:\\Users\\mhamz\\Hamza\\projects\\java\\MightyByte\\src\\main\\resources\\cucumber.xml");
		SpringApplication.run(MightyByteApplication.class, args);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
		PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
		c.setIgnoreUnresolvablePlaceholders(true);
		return c;
	}

}
