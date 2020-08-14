package com.d9nich.demo.beansAndComponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Printer {
    private final InkSupply inkSupply;

    @Autowired
    public Printer(InkSupply inkSupply) {
        this.inkSupply = inkSupply;
    }

    public void printHello() {
        System.out.println(inkSupply.getMessage());
    }
}
