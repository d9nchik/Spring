package com.d9nich.demo.beansAndComponents;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterConfiguration {
    @Bean
    public InkSupply getInkSupply() {
        //setting something in the inkSupply
        return new InkSupply();
    }

}
