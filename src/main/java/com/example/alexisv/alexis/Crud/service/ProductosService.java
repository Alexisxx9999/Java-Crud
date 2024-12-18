package com.example.alexisv.alexis.Crud.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alexisv.alexis.Crud.dto.ProductosDto;
import com.example.alexisv.alexis.Crud.entity.Productos;
import com.example.alexisv.alexis.Crud.repository.ProductosRepository;
import com.example.alexisv.alexis.global.exceptions.ResourceNotFoundException;

@Service
public class ProductosService {
  @Autowired
  ProductosRepository productosRepository;

  public List<Productos> getAll() {
    return productosRepository.findAll();
  }

  public Productos getOne(int id) throws ResourceNotFoundException {
    return productosRepository.findById(id)
          .orElseThrow(()-> new ResourceNotFoundException("not found"));
  }

  public Productos save(ProductosDto dto) {
    int id = autoIncrement();
    Productos productos = new Productos(id, dto.getName(), dto.getPrice());
    return productosRepository.save(productos);
  }
  public Productos update(int id,ProductosDto dto) throws ResourceNotFoundException {    
    Productos productos = productosRepository.findById(id)
                          .orElseThrow( ()-> new ResourceNotFoundException("not found"));
    productos.setName(dto.getName());
    productos.setPrice(dto.getPrice());
    return productosRepository.save(productos);
  }

  public Productos delete(int id) throws ResourceNotFoundException {
    Productos productos = productosRepository.findById(id)
    .orElseThrow( ()-> new ResourceNotFoundException("not found"));
    productosRepository.delete(productos);
    return productos;
  }

  /* metodos extras */
public List<Productos> updateAll(ProductosDto dto) {
    List<Productos> productosList = productosRepository.findAll();
    for (Productos producto : productosList) {
        producto.setName(dto.getName());
        producto.setPrice(dto.getPrice());
    }
    return productosRepository.saveAll(productosList);
}
 

public List<Productos> getProductosByPriceGreaterThan(double price) {
  return productosRepository.findByPriceGreaterThan(price);
}
 public void deleteAll() {
        productosRepository.deleteAll(); // Elimina todos los productos
    }

 


 
  // private methods
  private int autoIncrement() {
    List<Productos> productos = productosRepository.findAll();
    return productos.isEmpty() ? 1 : productos.stream().max(Comparator.comparing(Productos::getId)).get().getId() + 1;
  }
  
}
