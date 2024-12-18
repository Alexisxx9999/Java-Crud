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

import com.example.alexisv.alexis.Crud.dto.UsuariosDto;

import com.example.alexisv.alexis.Crud.entity.Usuarios;

import com.example.alexisv.alexis.Crud.service.UsuariosService;
import com.example.alexisv.alexis.global.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
  @Autowired
  UsuariosService usuariosService;

  
  @GetMapping
  public ResponseEntity<List<Usuarios>> getAll() {
    return ResponseEntity.ok(usuariosService.getAll());
  }
 
  @GetMapping("/{id:\\\\d+}")
  public ResponseEntity<Usuarios> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
    return ResponseEntity.ok(usuariosService.getOne(id));
  }
  
  @PostMapping
  public ResponseEntity<Usuarios> save(@RequestBody UsuariosDto dto) {
    return ResponseEntity.ok(usuariosService.save(dto));
  }
  
  @PutMapping("/{id:\\\\d+}")
  public ResponseEntity<Usuarios> update(@PathVariable("id") int id, @RequestBody UsuariosDto dto) throws ResourceNotFoundException {
    return ResponseEntity.ok(usuariosService.update(id, dto));
  }

  @DeleteMapping("/{id:\\\\d+}")
  public ResponseEntity<Usuarios> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
    return ResponseEntity.ok(usuariosService.delete(id));
  }
  /* extras */
   @PutMapping("/all")
    public ResponseEntity<List<Usuarios>> updateAll(@RequestBody UsuariosDto dto) {
        return ResponseEntity.ok(usuariosService.updateAll(dto));
    }

    // Obtener usuarios con precio mayor a un valor
/*    @GetMapping("/mayor-edad")
    public ResponseEntity<List<Usuarios>> getAll(@RequestParam(required = false) Integer edad) {
        if (edad != null) {
            return ResponseEntity.ok(usuariosService.getByEdadGreaterThan(edad));
        }
        return ResponseEntity.ok(usuariosService.getAll());
    } */
    /* eliminar todos los usuarios */
     @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        usuariosService.deleteAll();
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content
    }
}
