package com.github.senin24.jms.activemq.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

@Slf4j
public class Sender {

  @Autowired
  private JmsTemplate jmsTemplate;

  public void send(String destination, String message) {
    log.info("sending message='{}' to destination='{}'", message, destination);
    jmsTemplate.convertAndSend(destination, message);
  }
}
