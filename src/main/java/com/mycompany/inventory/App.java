package com.mycompany.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EntityScan(basePackages = {"com.mycompany.catalog.model", "com.mycompany.inventory.model"})
@PropertySource("classpath:dev_inventory.properties")
public class App {
    
    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }
}
