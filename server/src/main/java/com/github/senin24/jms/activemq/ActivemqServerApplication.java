package com.github.senin24.jms.activemq;

import com.github.senin24.jms.activemq.domain.MessageExample;
import com.github.senin24.jms.activemq.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ActivemqServerApplication implements ApplicationRunner {

    @Autowired
    private Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(ActivemqServerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        int i = 0;
        while (true) {
            MessageExample messageExample = new MessageExample((long) i, new Date(), i + " TEST MESSAGE");
            sender.send(messageExample);
            i++;
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        }
    }
}
