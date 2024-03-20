package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class MyApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyApp.class);
       // new TicTacToeFrame();
    }
}
