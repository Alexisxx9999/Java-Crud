package com.example.alexisv.alexis.Crud.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alexisv.alexis.Crud.dto.OrdenDto;

import com.example.alexisv.alexis.Crud.entity.Orden;

import com.example.alexisv.alexis.Crud.repository.OrdenRepository;
import com.example.alexisv.alexis.global.exceptions.ResourceNotFoundException;

@Service
public class OrdenService {
  @Autowired
  OrdenRepository ordenRepository;

  public List<Orden> getAll() {
    return ordenRepository.findAll();
  }
  public Orden getOne(int id) throws ResourceNotFoundException {
    return ordenRepository.findById(id)
          .orElseThrow(()-> new ResourceNotFoundException("not found"));
  }
 
  public Orden save(OrdenDto dto) {
    int id = autoIncrement();
    Orden orden = new Orden(id, dto.getFecha(), dto.getTotal());
    return ordenRepository.save(orden);
  }
  public Orden update(int id,OrdenDto dto) throws ResourceNotFoundException {    
    Orden orden = ordenRepository.findById(id)
                          .orElseThrow( ()-> new ResourceNotFoundException("not found"));
    orden.setFecha(dto.getFecha());
    orden.setTotal(dto.getTotal());
    return ordenRepository.save(orden);
  }

  public Orden delete(int id) throws ResourceNotFoundException {
    Orden orden = ordenRepository.findById(id)
    .orElseThrow( ()-> new ResourceNotFoundException("not found"));
    ordenRepository.delete(orden);
    return orden;
  }
/* metodos extras https */
  public List<Orden> updateAll(OrdenDto dto) {
    List<Orden> ordenList = ordenRepository.findAll();
    for (Orden producto : ordenList) {
        producto.setFecha(dto.getFecha());
        producto.setTotal(dto.getTotal());
    }
    return ordenRepository.saveAll(ordenList);
}
 

 public void deleteAll() {
        ordenRepository.deleteAll(); // Elimina todos los orden
    }

/* private methods */
private int autoIncrement() {
    List<Orden> orden = ordenRepository.findAll();
    return orden.isEmpty() ? 1 : orden.stream().max(Comparator.comparing(Orden::getId)).get().getId() + 1;
  }

}
