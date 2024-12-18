package com.example.alexisv.alexis.Crud.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="comentarios")
public class Comentarios {
  @Id
  private int id;
  private String descripcion;
  private int calificacion;

  public Comentarios() {

  }

  public Comentarios(int id, String descripcion, int calificacion) {
    this.id = id;
    this.calificacion = calificacion;
    this.descripcion = descripcion;

  }

  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  public String getDescripcion(){
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getCalificacion() {
    return calificacion;
  }
  public void setCalificacion(int calificacion) {
    this.calificacion = calificacion;
  }


  



}
