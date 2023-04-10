package com.example.demo;

//Class that can be used to bootstrap and launch a Spring application from a Java main method.
import org.springframework.boot.SpringApplication;
/* This is a convenience annotation that is equivalent to declaring
 @Configuration, @EnableAutoConfiguration and @ComponentScan.*/
import org.springframework.boot.autoconfigure.SpringBootApplication;
/* @SpringBootApplication. 
This annotation is known as a meta-annotation, 
it combines @SpringBootConfiguration,
@EnableAutoConfiguration and @ComponentScan */


@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
    }
}
