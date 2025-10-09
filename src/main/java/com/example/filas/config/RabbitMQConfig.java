package com.example.filas.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${filas.queue.proposta}")
    private String propostaQueueName;

    @Bean
    public Queue propostaQueue() {
        return QueueBuilder.durable(propostaQueueName).build();
    }
}
