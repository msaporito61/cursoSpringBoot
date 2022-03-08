package org.cursospring.demorest.repository;

import java.util.List;

import org.cursospring.demorest.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    List<Persona> findByName(@Param("name") String name);
}
