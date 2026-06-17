package com.atividade.jpql.mapper;

import com.atividade.jpql.dto.projeto.ProjetoRequest;
import com.atividade.jpql.dto.projeto.ProjetoResponse;
import com.atividade.jpql.model.Projeto;
import com.atividade.jpql.model.Tarefa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjetoMapper {

    public Projeto toEntity(ProjetoRequest req){
        Projeto projeto = new Projeto();

        projeto.setNome(req.nome());

        return projeto;
    }

    public ProjetoResponse toResponse(Projeto projeto){
        List<Long> ids = projeto.getTarefas().stream().map(Tarefa::getId).toList();
        return new ProjetoResponse(
                projeto.getId(),
                projeto.getNome(), ids
        );
    }
}
