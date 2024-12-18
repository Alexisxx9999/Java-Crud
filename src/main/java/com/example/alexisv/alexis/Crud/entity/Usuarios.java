package com.example.alexisv.alexis.Crud.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="usuarios")
public class Usuarios {
 
  @Id
  private int id;
  private String name;
  private int edad; 

  public Usuarios() {

  }

  public Usuarios(int id, String name, int edad) {

    this.id = id;
    this.name = name;
    this.edad = edad;

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
    
  }

}
 