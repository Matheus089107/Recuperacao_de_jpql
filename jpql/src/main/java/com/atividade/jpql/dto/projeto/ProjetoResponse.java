package com.atividade.jpql.dto.projeto;

import com.atividade.jpql.model.Tarefa;

import java.util.List;

public record ProjetoResponse(
        Long id,
        String nome,
        List<Long> tarefaId
) {
}
