package com.github.senin24.jms.activemq.producer;

import com.github.senin24.jms.activemq.domain.MessageExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;

@Slf4j
public class Sender {

  @Autowired
  private JmsTemplate jmsTemplate;

  @Value("${serverqueue.outbound}")
  private String queueDestination;

  public void send(MessageExample message) {
    log.info("sending message='{}' to destination='{}'", message.toString(), queueDestination);
    jmsTemplate.convertAndSend(queueDestination, message);
  }
}
