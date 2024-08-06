package com.TurkcellSRS.OrderService.Config.Event;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic orderCreatedTopic(){
        return new NewTopic("order-created", 1, (short) 1);
    }


    @Bean
    public NewTopic orderFailedTopic(){
        return new NewTopic("order-failed", 1, (short) 1);
    }
}
