package com.github.senin24.jms.activemq.consumer;

import com.github.senin24.jms.activemq.domain.MessageExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;

@Slf4j
public class Receiver {

  @JmsListener(destination = "${serverqueue.inbound}")
  public void receive(@Payload MessageExample message) {
    log.info("*** Receive modified message from Worker='{}'", message.toString());
  }
}
