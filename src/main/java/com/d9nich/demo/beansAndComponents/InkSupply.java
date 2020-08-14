package com.d9nich.demo.beansAndComponents;

import org.springframework.stereotype.Component;

public class InkSupply {
    private final String INK_MESSAGE = "This is ink supply";

    public String getMessage() {
        return INK_MESSAGE;
    }
}
