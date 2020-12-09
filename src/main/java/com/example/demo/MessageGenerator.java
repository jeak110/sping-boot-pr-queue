package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class MessageGenerator {

    private MessageSender messageSender;

    @Scheduled(fixedDelay = 5_000, initialDelay = 100)
    public void generateGradabilityMessage() {
        messageSender.sendGradabilityMessage();
    }

    @Scheduled(fixedDelay = 20_000, initialDelay = 100)
    public void generateAnalysisMessage() {
        messageSender.sendAnalysisMessage();
    }

}
