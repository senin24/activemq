package com.github.senin24.jms.activemq.consumer;

import com.github.senin24.jms.activemq.domain.MessageExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Receiver {

    @Value("${worker.current-node-number}")
    private int currentNodeNumber;

    @JmsListener(destination = "${serverqueue.outbound}")
    @SendTo("${serverqueue.inbound}")
    public MessageExample receive(@Payload MessageExample message) throws InterruptedException {
        log.info("*** Received message from Server='{}'", message.toString());
        message.setMessage("This message was modified from Worker Number [" + currentNodeNumber + "]! " + message.getMessage());
        TimeUnit.SECONDS.sleep(new Random().nextInt(10)); //worker working hard!
        log.info("*** Modify and send message return to Server='{}'", message.toString());
        return message;
    }
}
