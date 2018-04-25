package com.greenfox.cloth.controllers;

import com.greenfox.cloth.models.Cloth;
import com.greenfox.cloth.repositories.ClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class WarehouseMainController {

  ClothRepository clothRepository;

  @Autowired
  public WarehouseMainController(ClothRepository clothRepository) {
    this.clothRepository = clothRepository;
  }

  @GetMapping("/warehouse")
  public String renderIndexPage(@ModelAttribute(name = "cloth")Cloth cloth, Model model) {
    model.addAttribute("clothes",clothRepository.findAll());
    model.addAttribute("cloth", new Cloth());
    return "index";
  }

}
