package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
public class MessageSender {
    private static final String EXCHANGE = "priority-exchange";
    private static final String ROUTING_KEY_PREFIX = "priority.queue.";
    private final RabbitTemplate rabbitTemplate;


    public void sendGradabilityMessage() {
        String payload = UUID.randomUUID().toString();
        Message grMessage = new Message("gradability", payload);
        log.info("send gradability message " + payload);
        sendPriorityMessage(grMessage, 50);
    }

    public void sendAnalysisMessage() {
        String payload = UUID.randomUUID().toString();
        Message aMessage = new Message("analysis", payload);
        log.info("send analysis message " + payload);
        sendPriorityMessage(aMessage, 1);
    }

    public void sendPriorityMessage(Message msg, Integer priority) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_PREFIX + "test", msg,
                message -> {
                    message.getMessageProperties().setPriority(priority);
                    return message;
                });
    }
}
