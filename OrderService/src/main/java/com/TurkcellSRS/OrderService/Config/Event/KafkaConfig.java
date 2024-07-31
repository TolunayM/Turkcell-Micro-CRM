package com.TurkcellSRS.OrderService.Config.Event;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic orderCreatedTopic(){
        return new NewTopic("orderCreated", 1, (short) 1);
    }


    @Bean
    public NewTopic orderFailedTopic(){
        return new NewTopic("orderFailed", 1, (short) 1);
    }
}
