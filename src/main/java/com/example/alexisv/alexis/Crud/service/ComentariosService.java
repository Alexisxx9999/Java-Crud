package com.example.alexisv.alexis.Crud.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alexisv.alexis.Crud.dto.ComentariosDto;

import com.example.alexisv.alexis.Crud.entity.Comentarios;

import com.example.alexisv.alexis.Crud.repository.ComentariosRepository;
import com.example.alexisv.alexis.global.exceptions.ResourceNotFoundException;

@Service
public class ComentariosService {

  @Autowired
  ComentariosRepository comentariosRepository; 

  public List<Comentarios> getAll() {
    return comentariosRepository.findAll();
  }
  public Comentarios getOne(int id) throws ResourceNotFoundException {
    return comentariosRepository.findById(id)
          .orElseThrow(()-> new ResourceNotFoundException("not found"));
  }

  public Comentarios save(ComentariosDto dto) {
    int id = autoIncrement();
    Comentarios comentarios = new Comentarios(id, dto.getDescripcion(), dto.getCalificacion());
    return comentariosRepository.save(comentarios);
  }
  public Comentarios update(int id,ComentariosDto dto) throws ResourceNotFoundException {    
    Comentarios comentarios = comentariosRepository.findById(id)
                          .orElseThrow( ()-> new ResourceNotFoundException("not found"));
    comentarios.setDescripcion(dto.getDescripcion());
    comentarios.setCalificacion(dto.getCalificacion());
    return comentariosRepository.save(comentarios);
  }

  public Comentarios delete(int id) throws ResourceNotFoundException {
    Comentarios comentarios = comentariosRepository.findById(id)
    .orElseThrow( ()-> new ResourceNotFoundException("not found"));
    comentariosRepository.delete(comentarios);
    return comentarios;
  }
  /* metodos extras https */
public List<Comentarios> updateAll(ComentariosDto dto) {
    List<Comentarios> comentariosList = comentariosRepository.findAll();
    for (Comentarios comentario : comentariosList) {
      comentario.setDescripcion(dto.getDescripcion());
        comentario.setCalificacion(dto.getCalificacion());
    }
    return comentariosRepository.saveAll(comentariosList);
}
 


 public void deleteAll() {
        comentariosRepository.deleteAll(); // Elimina todos los comentarios
    }
 


  
/* private methods */
private int autoIncrement() {
    List<Comentarios> comentarios = comentariosRepository.findAll();
    return comentarios.isEmpty() ? 1 : comentarios.stream().max(Comparator.comparing(Comentarios::getId)).get().getId() + 1;
  }

}
 