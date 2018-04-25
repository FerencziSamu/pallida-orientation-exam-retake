package com.greenfox.cloth.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "warehouse")
public class Cloth {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(length = 80)
  private String itemName;

  @Column(length = 30)
  private String manufacturer;

  @Column(length = 30)
  private String category;

  @Column(length = 4)
  private String size;

  private float unitPrice;
  private Integer inStore;

}