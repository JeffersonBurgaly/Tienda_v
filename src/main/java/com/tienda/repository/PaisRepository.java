package com.tienda.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.tienda.entity.Pais;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {
    
}
