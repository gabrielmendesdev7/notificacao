package com.javanauta.notificacao.infrastructure.messages.kafka.producer;

import com.javanauta.notificacao.business.dto.StatusTarefaPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void enviarStatusTarefa(StatusTarefaPayload payload) {
        try {
            String json = objectMapper.writeValueAsString(payload);
            kafkaTemplate.send("status-notificacao", json);
        } catch (JacksonException e) {
            throw new RuntimeException("Erro ao enviar mensagem para o Kafka", e);
        }
    }

}
