package com.atividade.jpql.service;

import com.atividade.jpql.dto.TarefaRelatorioDTO;
import com.atividade.jpql.dto.tarefa.TarefaRequest;
import com.atividade.jpql.dto.tarefa.TarefaResponse;
import com.atividade.jpql.dto.tarefa.TarefaUpdateRequest;
import com.atividade.jpql.mapper.TarefaMapper;
import com.atividade.jpql.model.Projeto;
import com.atividade.jpql.model.Tarefa;
import com.atividade.jpql.repository.ProjetoRepository;
import com.atividade.jpql.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    @Autowired
    private TarefaRepository repository;
    @Autowired
    private TarefaMapper mapper;
    @Autowired
    private ProjetoRepository projetoRepository;

    public TarefaResponse criarTarefa(TarefaRequest req){

        Projeto projeto = projetoRepository.findById(req.projetoId())
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        Tarefa tarefa = mapper.toEntity(req, projeto);
        Tarefa tarefaSave = repository.save(tarefa);

        return mapper.toResponse(tarefaSave);
    }

    public List<TarefaResponse> listarTarefa(){
        List<Tarefa> tarefas = repository.findAll();
        return tarefas.stream().map(tarefa -> mapper.toResponse(tarefa)).toList();
    }

    public TarefaResponse atualizarTarefa(Long id, TarefaUpdateRequest reqUpd){
        Tarefa tarefa = repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o id: " + id));

        tarefa.setTitulo(reqUpd.titulo());
        tarefa.setCodigo(reqUpd.codigo());
        tarefa.setCusto(reqUpd.custo());

        Tarefa tarefaUpd = repository.save(tarefa);
        return mapper.toResponse(tarefaUpd);
    }

    public void dltTarefa(Long id){
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada..."));
        repository.delete(tarefa);
    }

    public TarefaResponse BuscarPorId(Long id){
        Tarefa tarefa = repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o ID:" + id));
        return mapper.toResponse(tarefa);
    }

    public List<TarefaResponse> listarTarefasPorProjeto(Long projetoId){
        if(!projetoRepository.existsById(projetoId)){
            throw new RuntimeException("Projeto não encontrado com o ID: " + projetoId);
        }
        List<Tarefa> tarefas = repository.listarTarefasPorProjetoId(projetoId);
        return tarefas.stream().map(mapper::toResponse).toList();
    }

    public List<TarefaRelatorioDTO> listarRelatorioAvancado(){
        return repository.listarRelatorioAvancado();
    }
}
