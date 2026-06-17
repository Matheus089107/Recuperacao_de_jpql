package com.atividade.jpql.controller;

import com.atividade.jpql.dto.TarefaRelatorioDTO;
import com.atividade.jpql.dto.tarefa.TarefaRequest;
import com.atividade.jpql.dto.tarefa.TarefaResponse;
import com.atividade.jpql.dto.tarefa.TarefaUpdateRequest;
import com.atividade.jpql.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService service;

    @PostMapping
    public TarefaResponse criarTarefa(@RequestBody TarefaRequest req){
        return service.criarTarefa(req);
    }
    @GetMapping("/{id}")
    public TarefaResponse buscarPorId(@PathVariable Long id){
        return service.BuscarPorId(id);
    }
    @GetMapping
    public List<TarefaResponse> listarTarefas(){
        return service.listarTarefa();
    }
    @PutMapping("/{id}")
    public TarefaResponse updateTarefa(@PathVariable Long id, @RequestBody TarefaUpdateRequest req){
        return service.atualizarTarefa(id, req);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTarefa(@PathVariable Long id){
        service.dltTarefa(id);
    }
    @GetMapping("/relatorio")
    public List<TarefaRelatorioDTO> listarRelatorioAvancado(){
        return service.listarRelatorioAvancado();
    }
}
