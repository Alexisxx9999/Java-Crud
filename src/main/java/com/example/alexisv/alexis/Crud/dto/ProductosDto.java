package com.example.alexisv.alexis.Crud.dto;

public class ProductosDto {
  private String name;
  private int price;

  public ProductosDto() {
  }  
  public ProductosDto(String name, int price) {     
    this.name = name;
    this.price = price;
  }

  

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;

  }
  

}
