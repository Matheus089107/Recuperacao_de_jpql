package com.atividade.jpql.controller;

import com.atividade.jpql.dto.projeto.ProjetoRequest;
import com.atividade.jpql.dto.projeto.ProjetoResponse;
import com.atividade.jpql.dto.projeto.ProjetoUpdateRequest;
import com.atividade.jpql.dto.tarefa.TarefaResponse;
import com.atividade.jpql.service.ProjetoService;
import com.atividade.jpql.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {
    @Autowired
    private TarefaService tarefaService;
    @Autowired
    private ProjetoService service;

    @PostMapping
    public ProjetoResponse criarProjeto(@RequestBody ProjetoRequest req){
        return service.criarProjeto(req);
    }
    @GetMapping("/{id}")
    public ProjetoResponse buscarPorId(@PathVariable Long id){
       return service.BuscarPorID(id);
    }
    @GetMapping
    public List<ProjetoResponse> listarProjetos(){
        return service.listarProjetos();
    }
    @PutMapping("/{id}")
    public ProjetoResponse updateProjeto(@PathVariable Long id, @RequestBody ProjetoUpdateRequest req){
        return service.updateProjeto(id, req);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dltProjeto(@PathVariable Long id){
        service.deleteProjeto(id);
    }
    @GetMapping("/{id}/tarefas")
    public List<TarefaResponse> listarTarefasPorProjeto(@PathVariable Long id){
        return tarefaService.listarTarefasPorProjeto(id);
    }
}
