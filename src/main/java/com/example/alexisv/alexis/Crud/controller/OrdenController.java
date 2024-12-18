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

import com.example.alexisv.alexis.Crud.dto.OrdenDto;

import com.example.alexisv.alexis.Crud.entity.Orden;

import com.example.alexisv.alexis.Crud.service.OrdenService;
import com.example.alexisv.alexis.global.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
@Autowired
  OrdenService ordenService;
   
  @GetMapping
  public ResponseEntity<List<Orden>> getAll() {
    return ResponseEntity.ok(ordenService.getAll());
  }

  @GetMapping("/{id:\\\\d+}")
  public ResponseEntity<Orden> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
    return ResponseEntity.ok(ordenService.getOne(id));
  }
  
  @PostMapping 
  public ResponseEntity<Orden> save(@RequestBody OrdenDto dto) {
    return ResponseEntity.ok(ordenService.save(dto));
  }
  
  @PutMapping("/{id:\\\\d+}")
  public ResponseEntity<Orden> update(@PathVariable("id") int id, @RequestBody OrdenDto dto) throws ResourceNotFoundException {
    return ResponseEntity.ok(ordenService.update(id, dto));
  }

  @DeleteMapping("/{id:\\\\d+}")
  public ResponseEntity<Orden> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
    return ResponseEntity.ok(ordenService.delete(id));
  }

  /* extras */
   @PutMapping("/all")
    public ResponseEntity<List<Orden>> updateAll(@RequestBody OrdenDto dto) {
        return ResponseEntity.ok(ordenService.updateAll(dto));
    }

    

    /* eliminar todos los orden */
     @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        ordenService.deleteAll();
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content
    }

}
 