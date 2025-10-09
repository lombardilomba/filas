package com.example.filas.messaging;

import com.example.filas.dto.PropostaDTO;
import com.example.filas.usecase.SalvarPropostaUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PropostaMessageListener {

    static final String LISTENER_ID = "propostaMessageListener";

    private final ObjectMapper objectMapper;
    private final SalvarPropostaUseCase salvarPropostaUseCase;

    @RabbitListener(id = PropostaMessageListener.LISTENER_ID, queues = "${filas.queue.proposta}")
    public void onMessage(String message) {
        try {
            PropostaDTO propostaDTO = objectMapper.readValue(message, PropostaDTO.class);
            salvarPropostaUseCase.execute(propostaDTO);
        } catch (JsonProcessingException ex) {
            log.error("Falha ao converter mensagem de proposta recebida do RabbitMQ", ex);
            throw new IllegalArgumentException("Mensagem de proposta inválida", ex);
        }
    }
}
