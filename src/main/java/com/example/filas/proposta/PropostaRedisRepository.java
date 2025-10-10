package com.example.filas.proposta;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.UncheckedIOException;
import java.util.Optional;

@Component
public class PropostaRedisRepository {

    private final StringRedisTemplate stringRedisTemplate;
    private final ObjectMapper objectMapper;

    public PropostaRedisRepository(StringRedisTemplate stringRedisTemplate, ObjectMapper objectMapper) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.objectMapper = objectMapper;
    }

    public void save(Proposta proposta) {
        Assert.notNull(proposta, "Proposta não pode ser nula");
        Assert.hasText(proposta.id(), "Identificador da proposta é obrigatório");

        try {
            String key = buildKey(proposta.id());
            String serialized = objectMapper.writeValueAsString(proposta);
            stringRedisTemplate.opsForValue().set(key, serialized);
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException("Erro ao serializar proposta para JSON", e);
        } catch (DataAccessException e) {
            throw new IllegalStateException("Falha ao salvar proposta no Redis", e);
        }
    }

    public Optional<Proposta> findById(String id) {
        Assert.hasText(id, "Identificador da proposta é obrigatório");

        try {
            String key = buildKey(id);
            String serialized = stringRedisTemplate.opsForValue().get(key);
            if (serialized == null) {
                return Optional.empty();
            }
            return Optional.of(objectMapper.readValue(serialized, Proposta.class));
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException("Erro ao desserializar proposta do JSON", e);
        } catch (DataAccessException e) {
            throw new IllegalStateException("Falha ao ler proposta do Redis", e);
        }
    }

    private String buildKey(String id) {
        return "proposta:" + id;
    }
}
