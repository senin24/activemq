package com.github.senin24.jms.activemq.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import java.io.File;

@Slf4j
@Configuration
public class SenderConfig {

  @Value("${spring.activemq.broker-url}")
  private String brokerUrl;

  @Bean
  public ActiveMQConnectionFactory activeMQConnectionFactory() {
    ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
    activeMQConnectionFactory.setBrokerURL(brokerUrl);
    return activeMQConnectionFactory;
  }

  @Bean
  public CachingConnectionFactory cachingConnectionFactory() {
    return new CachingConnectionFactory(activeMQConnectionFactory());
  }

  @Bean
  public JmsTemplate jmsTemplate() {
    return new JmsTemplate(cachingConnectionFactory());
  }

  @Bean
  public BrokerService broker() throws Exception {
    File dir = new File("foo");
    dir.mkdir();
    BrokerService broker = new BrokerService();
    broker.setDataDirectory(String.valueOf(dir));
    broker.addConnector(brokerUrl);
    return broker;
  }

  @Bean
  public Sender sender() {
    return new Sender();
  }
}
