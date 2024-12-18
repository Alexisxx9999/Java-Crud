package com.example.alexisv.alexis.Crud.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.alexisv.alexis.Crud.entity.Productos;
@Repository
public interface ProductosRepository extends MongoRepository<Productos,Integer> {
   List<Productos> findByPriceGreaterThan(double price);
}

 
