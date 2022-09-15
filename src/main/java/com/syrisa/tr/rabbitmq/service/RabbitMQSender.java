package com.syrisa.tr.rabbitmq.service;


import com.syrisa.tr.rabbitmq.model.Employee;
import com.syrisa.tr.rabbitmq.model.MessageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RabbitMQSender {


    private final AmqpTemplate rabbitTemplate;

    @Value("${sb.rabbitmq.exchange}")
    private String exchange;

    @Value("${sb.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee company) {
        try {
            for (int i = 0; i < 10; i++) {
                company.setEmpId(String.valueOf(i + 1));
                rabbitTemplate.convertAndSend(exchange, routingkey, company);
                System.out.println("Send msg = " + company);
                 Thread.sleep(1000);

            }
        } catch (InterruptedException exception) {
            System.out.println(exception.getMessage());
        }
    }


    public void sendMessage(MessageInfo messageInfo) {
        // System.out.println(messageInfo);
        rabbitTemplate.convertAndSend(exchange, routingkey, messageInfo.getMessage());
        System.out.println("Send msg = " + messageInfo);
    }
}
