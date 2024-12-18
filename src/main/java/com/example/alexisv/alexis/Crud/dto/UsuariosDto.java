package com.example.alexisv.alexis.Crud.dto;

public class UsuariosDto {

  private String name;
  private int edad; 

  public UsuariosDto() { 

  }
  public UsuariosDto( String name, int edad) {    
    this.name = name;
    this.edad = edad;

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
 