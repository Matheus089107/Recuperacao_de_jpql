package com.atividade.jpql.mapper;

import com.atividade.jpql.dto.tarefa.TarefaRequest;
import com.atividade.jpql.dto.tarefa.TarefaResponse;
import com.atividade.jpql.model.Projeto;
import com.atividade.jpql.model.Tarefa;
import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {

    public Tarefa toEntity(TarefaRequest req, Projeto projeto){
        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(req.titulo());
        tarefa.setCodigo(req.codigo());
        tarefa.setCusto(req.custo());
        tarefa.setProjeto(projeto);

        return tarefa;
    }

    public TarefaResponse toResponse(Tarefa tarefa){
        return new TarefaResponse(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getCodigo(),
                tarefa.getCusto(),
                tarefa.getDataCriacao(),
                tarefa.getProjeto().getId()
        );
    }
}
