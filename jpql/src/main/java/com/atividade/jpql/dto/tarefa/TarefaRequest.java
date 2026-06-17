package com.atividade.jpql.dto.tarefa;

import com.atividade.jpql.model.Projeto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TarefaRequest(
        String titulo,
        String codigo,
        BigDecimal custo,
        Long projetoId
) {
}
