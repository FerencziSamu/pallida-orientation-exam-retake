package com.greenfox.cloth.controllers;

import com.greenfox.cloth.models.ClothResponse;
import com.greenfox.cloth.repositories.ClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseRestController {

  @Autowired
  ClothRepository clothRepository;

  @GetMapping("/warehouse/query")
  public ClothResponse showingCloths() {
    return new ClothResponse(clothRepository.findAll());
  }

}
