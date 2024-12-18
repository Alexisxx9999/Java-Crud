package com.example.alexisv.alexis.Crud.repository;





import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.alexisv.alexis.Crud.entity.Orden;

@Repository
public interface OrdenRepository extends MongoRepository<Orden, Integer> {
    
}
 