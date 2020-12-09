package com.example.demo;

import lombok.*;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Message implements Serializable {
    private String type;
    private String payload;
}
