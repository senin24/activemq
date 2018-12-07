package com.github.senin24.jms.activemq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString
public class MessageExample {
    private Long id;
    private Date timestamp;
    private String message;
}
