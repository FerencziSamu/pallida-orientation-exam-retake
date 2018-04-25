package com.greenfox.cloth.models;

public class Summary {

  private String item;
  private String size;
  private int quantity;

  public Summary(){
  }

  // Getters and Setters
  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

}
