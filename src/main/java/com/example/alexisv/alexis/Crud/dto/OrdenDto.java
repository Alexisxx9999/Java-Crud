package com.example.alexisv.alexis.Crud.dto;

public class OrdenDto { 
  private String fecha;
private int total;
 public OrdenDto() {

  }

  public OrdenDto( String fecha, int total) {
    
    this.total = total;
    this.fecha = fecha;

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
