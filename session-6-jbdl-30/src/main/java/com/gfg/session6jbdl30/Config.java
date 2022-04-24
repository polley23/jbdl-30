package com.gfg.session6jbdl30;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    Printer printer(){
        return new PrinterImpl();
    }

    @Bean
    ClassB classB(){
        return new ClassB(printer());
    }
}
