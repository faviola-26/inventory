package com.mycompany.inventory;

import com.mycompany.catalog.model.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import({Category.class})
@SpringBootApplication
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }
}
