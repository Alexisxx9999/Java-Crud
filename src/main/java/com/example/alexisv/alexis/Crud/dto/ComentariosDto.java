package com.example.alexisv.alexis.Crud.dto;

public class ComentariosDto {
private String descripcion;
  private int calificacion;

  public ComentariosDto() {
  }

  public ComentariosDto(String descripcion, int calificacion) {    
    this.calificacion = calificacion;
    this.descripcion = descripcion;

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
