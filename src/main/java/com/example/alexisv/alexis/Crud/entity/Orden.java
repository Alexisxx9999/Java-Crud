package com.example.alexisv.alexis.Crud.entity;

import org.springframework.data.annotation.Id;

public class Orden {

@Id
private int id;
private String fecha;
private int total;
 public Orden() {

  }

  public Orden(int id, String fecha, int total) {
    this.id = id;
    this.total = total;
    this.fecha = fecha;

  }

  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  public String getFecha(){
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public int getTotal() {
    return total;
  }
  public void setTotal(int total) {
    this.total = total;
  }




}
