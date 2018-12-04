package com.github.senin24.jms.activemq;

import com.github.senin24.jms.activemq.service.SenderService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.ConnectionFactory;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ActivemqServerApplication implements ApplicationRunner {

	@Autowired
	private SenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(ActivemqServerApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (int i = 0; i < 100; i++){
			senderService.send(i + "");
		}
		TimeUnit.DAYS.sleep(1);
	}
}
