package com.atividade.jpql.repository;

import com.atividade.jpql.model.Projeto;
import org.hibernate.boot.jaxb.mapping.spi.JaxbPersistentAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
