package com.atividade.jpql.service;

import com.atividade.jpql.dto.projeto.ProjetoRequest;
import com.atividade.jpql.dto.projeto.ProjetoResponse;
import com.atividade.jpql.dto.projeto.ProjetoUpdateRequest;
import com.atividade.jpql.mapper.ProjetoMapper;
import com.atividade.jpql.model.Projeto;
import com.atividade.jpql.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;
    @Autowired
    private ProjetoMapper mapper;

    public ProjetoResponse criarProjeto(ProjetoRequest req){
        Projeto projeto = mapper.toEntity(req);
        Projeto projetoSave =  repository.save(projeto);
        return mapper.toResponse(projetoSave);
    }
    public ProjetoResponse BuscarPorID(Long id){
        Projeto projeto = repository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado com o ID:  + id"));
        return mapper.toResponse(projeto);
    }
    public List<ProjetoResponse> listarProjetos(){
        List<Projeto> projetos = repository.findAll();
        return projetos.stream()
                .map(projeto -> mapper.toResponse(projeto))
                        .toList();
    }

    public ProjetoResponse updateProjeto(Long id, ProjetoUpdateRequest reqUpd){
        Projeto projeto = repository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado com o ID: " + id));
        projeto.setNome(reqUpd.nome());

        Projeto projetoUdp = repository.save(projeto);
        return mapper.toResponse(projetoUdp);
    }

    public void deleteProjeto(Long id){
        Projeto projeto = repository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado com o ID: " + id));
        repository.delete(projeto);
    }
}
