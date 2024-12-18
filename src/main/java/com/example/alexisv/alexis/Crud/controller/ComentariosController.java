package com.example.alexisv.alexis.Crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.alexisv.alexis.Crud.dto.ComentariosDto;

import com.example.alexisv.alexis.Crud.entity.Comentarios;

import com.example.alexisv.alexis.Crud.service.ComentariosService;
import com.example.alexisv.alexis.global.exceptions.ResourceNotFoundException;

@RestController 
@RequestMapping("/comentarios")
public class ComentariosController {

  @Autowired
  ComentariosService comentariosService;
   
  @GetMapping
  public ResponseEntity<List<Comentarios>> getAll() {
    return ResponseEntity.ok(comentariosService.getAll());
  }

  @GetMapping("/{id:\\\\d+}")
  public ResponseEntity<Comentarios> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
    return ResponseEntity.ok(comentariosService.getOne(id));
  }
  
  @PostMapping
  public ResponseEntity<Comentarios> save(@RequestBody ComentariosDto dto) {
    return ResponseEntity.ok(comentariosService.save(dto));
  }
  
  @PutMapping("/{id:\\\\d+}")
  public ResponseEntity<Comentarios> update(@PathVariable("id") int id, @RequestBody ComentariosDto dto) throws ResourceNotFoundException {
    return ResponseEntity.ok(comentariosService.update(id, dto));
  }

  @DeleteMapping("/{id:\\\\d+}")
  public ResponseEntity<Comentarios> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
    return ResponseEntity.ok(comentariosService.delete(id));
  }
  /* extras */
   @PutMapping("/all")
    public ResponseEntity<List<Comentarios>> updateAll(@RequestBody ComentariosDto dto) {
        return ResponseEntity.ok(comentariosService.updateAll(dto));
    }

    // Obtener comentarios con precio mayor a un valor
  /*    @GetMapping("/mayor-calificacion")
    public ResponseEntity<List<Comentarios>> getAll(@RequestParam(required = false) Integer calificacion) {
      if (calificacion != null) {
        return ResponseEntity.ok(comentariosService.getByCalificacionGreaterThan(calificacion));
      }
        
        return ResponseEntity.ok(comentariosService.getAll());
    } */
    /* eliminar todos los comentarios */
     @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        comentariosService.deleteAll();
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content
    }

 
}
