package com.github.senin24.jms.activemq.service;

import com.github.senin24.jms.activemq.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    @Autowired
    private Sender sender;
    @Value("${queue.task}")
    private String queue;

//    @Autowired
//    public SenderService(Sender sender) {
//        this.sender = sender;
//    }
//
//    @Autowired
//    public SenderService() {
//        this.sender = sender;
//    }

    public void send(String message){
        sender.send(queue, message);
    }


}
