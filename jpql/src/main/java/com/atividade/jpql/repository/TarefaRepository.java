package com.atividade.jpql.repository;

import com.atividade.jpql.dto.TarefaRelatorioDTO;
import com.atividade.jpql.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("Select t from Tarefa t join fetch t.projeto p where p.id = :projetoId")
    List<Tarefa> listarTarefasPorProjetoId(@Param("projetoId") Long projetoId);

    @Query(value = "select t.titulo as tituloTarefa, t.custo as custo, p.nome as nomeProjeto " +
                    "From tarefa t " + "Inner join projeto p on t.projeto_id = p.id",
            nativeQuery = true)
    List<TarefaRelatorioDTO> listarRelatorioAvancado();

}
