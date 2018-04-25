package com.greenfox.cloth.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ClothResponse {

  private String result;
  private List<Cloth> cloths;

  public ClothResponse(List<Cloth> listOfCloths) {
    this.cloths = listOfCloths;
    this.result = "ok";
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public List<Cloth> getCloths() {
    return cloths;
  }

  public void setCloths(List<Cloth> cloths) {
    this.cloths = cloths;
  }
}
