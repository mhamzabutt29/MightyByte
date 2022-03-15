package com.example.MightyByte;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
//@ImportResource("classpath*:applicationContext.xml")
class MightyByteApplicationTests {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("C:\\Users\\mhamz\\Hamza\\projects\\java\\MightyByte\\src\\test\\resources\\applicationContext.xml");
		SpringApplication.run(MightyByteApplication .class,args);
	}
	@Test
	void contextLoads() {
	}

}
