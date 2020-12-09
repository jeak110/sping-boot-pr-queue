package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class MessageListener {

    @RabbitListener(queues = "priority-queue")
    public void listen(Message msg) throws InterruptedException {
        Message message = (Message) msg;

        log.info("processing (T" + Thread.currentThread().getId() + ")" + message.getType() + " message " + message.getPayload());
        if ("gradability".equals(message.getType())) {
            Thread.sleep(1_000);
        }
        if ("analysis".equals(message.getType())) {
            Thread.sleep(30_000);
        }
    }

}


