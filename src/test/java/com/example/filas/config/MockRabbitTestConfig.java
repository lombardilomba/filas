package com.example.filas.config;

import com.example.filas.messaging.PropostaMessageListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

@TestConfiguration
public class MockRabbitTestConfig {

    @Bean
    public RabbitMessagePublisher rabbitMessagePublisher(
            @Value("${filas.queue.proposta}") String propostaQueueName,
            PropostaMessageListener propostaMessageListener) {
        return new RabbitMessagePublisher(propostaQueueName, propostaMessageListener);
    }

    public static class RabbitMessagePublisher {

        private final String expectedQueueName;
        private final PropostaMessageListener propostaMessageListener;

        RabbitMessagePublisher(String expectedQueueName, PropostaMessageListener propostaMessageListener) {
            this.expectedQueueName = expectedQueueName;
            this.propostaMessageListener = propostaMessageListener;
        }

        public void send(String queue, String message) {
            if (!Objects.equals(expectedQueueName, queue)) {
                throw new IllegalArgumentException("Fila inesperada: " + queue);
            }
            propostaMessageListener.onMessage(message);
        }
    }
}
