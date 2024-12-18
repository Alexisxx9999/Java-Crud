package com.example.alexisv.alexis.Crud.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.example.alexisv.alexis.Crud.entity.Usuarios;
@Repository
public interface UsuariosRepository extends MongoRepository<Usuarios,Integer> {  
   

}
 