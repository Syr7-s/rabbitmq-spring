package com.syrisa.tr.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageInfo {
    private String message;

    @Override
    public String toString() {
        return message;

    }
}
