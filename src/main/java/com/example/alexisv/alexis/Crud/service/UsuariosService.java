package com.example.alexisv.alexis.Crud.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alexisv.alexis.Crud.dto.UsuariosDto;

import com.example.alexisv.alexis.Crud.entity.Usuarios;

import com.example.alexisv.alexis.Crud.repository.UsuariosRepository;
import com.example.alexisv.alexis.global.exceptions.ResourceNotFoundException;
 
@Service
public class UsuariosService {
 
  @Autowired
  UsuariosRepository usuariosRepository;

  public List<Usuarios> getAll() {
    return usuariosRepository.findAll();
  }
  public Usuarios getOne(int id) throws ResourceNotFoundException {
    return usuariosRepository.findById(id)
          .orElseThrow(()-> new ResourceNotFoundException("not found"));
  }

  public Usuarios save(UsuariosDto dto) {
    int id = autoIncrement();
    Usuarios usuarios = new Usuarios(id, dto.getName(), dto.getEdad());
    return usuariosRepository.save(usuarios);
  }
  public Usuarios update(int id,UsuariosDto dto) throws ResourceNotFoundException {    
    Usuarios usuarios = usuariosRepository.findById(id)
                          .orElseThrow( ()-> new ResourceNotFoundException("not found"));
    usuarios.setName(dto.getName());
    usuarios.setEdad(dto.getEdad());
    return usuariosRepository.save(usuarios);
  }

  public Usuarios delete(int id) throws ResourceNotFoundException {
    Usuarios usuarios = usuariosRepository.findById(id)
    .orElseThrow( ()-> new ResourceNotFoundException("not found"));
    usuariosRepository.delete(usuarios);
    return usuarios;
  }
/* metodos extras https */
  public List<Usuarios> updateAll(UsuariosDto dto) {
    List<Usuarios> usuariosList = usuariosRepository.findAll();
    for (Usuarios producto : usuariosList) {
        producto.setName(dto.getName());
        producto.setEdad(dto.getEdad());
    }
    return usuariosRepository.saveAll(usuariosList);
}
 

 
 public void deleteAll() {
        usuariosRepository.deleteAll(); // Elimina todos los usuarios
    }

/* private methods */
private int autoIncrement() {
    List<Usuarios> usuarios = usuariosRepository.findAll();
    return usuarios.isEmpty() ? 1 : usuarios.stream().max(Comparator.comparing(Usuarios::getId)).get().getId() + 1;
  }
}
