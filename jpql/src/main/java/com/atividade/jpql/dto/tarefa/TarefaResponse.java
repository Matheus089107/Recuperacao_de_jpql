package com.atividade.jpql.dto.tarefa;


import java.math.BigDecimal;
import java.time.LocalDate;

public record TarefaResponse(
        Long id,
        String titulo,
        String codigo,
        BigDecimal custo,
        LocalDate dataCriacao,
        Long projetoId
) {
}
