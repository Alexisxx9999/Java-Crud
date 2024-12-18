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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.alexisv.alexis.Crud.dto.ProductosDto;
import com.example.alexisv.alexis.Crud.entity.Productos;
import com.example.alexisv.alexis.Crud.service.ProductosService;
import com.example.alexisv.alexis.global.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    ProductosService productosService;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Productos>> getAll() {
        return ResponseEntity.ok(productosService.getAll());
    }

    // Obtener un producto específico por ID (solo números)
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<Productos> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productosService.getOne(id));
    }

    // Guardar un nuevo producto
    @PostMapping
    public ResponseEntity<Productos> save(@RequestBody ProductosDto dto) {
        return ResponseEntity.ok(productosService.save(dto));
    }

    // Actualizar un producto específico por ID
    @PutMapping("/{id:\\d+}")
    public ResponseEntity<Productos> update(@PathVariable("id") int id, @RequestBody ProductosDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(productosService.update(id, dto));
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<Productos> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productosService.delete(id));
    }

    /* Métodos adicionales */

    // Actualizar todos los productos
    @PutMapping("/all")
    public ResponseEntity<List<Productos>> updateAll(@RequestBody ProductosDto dto) {
        return ResponseEntity.ok(productosService.updateAll(dto));
    }

    // Obtener productos con precio mayor a un valor
    @GetMapping("/precio-mayor")
    public ResponseEntity<List<Productos>> getProductosByPriceGreaterThan(@RequestParam double price) {
      List<Productos> productos = productosService.getProductosByPriceGreaterThan(price);
      return ResponseEntity.ok(productos);
    }
    /* eliminar todos los productos */
     @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        productosService.deleteAll();
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content
    }
}