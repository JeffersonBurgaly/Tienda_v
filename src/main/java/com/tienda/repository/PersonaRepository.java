package com.tienda.repository;

import com.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona,Long>{
    
}
