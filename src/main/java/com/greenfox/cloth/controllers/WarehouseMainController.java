package com.greenfox.cloth.controllers;

import com.greenfox.cloth.models.Cloth;
import com.greenfox.cloth.models.Summary;
import com.greenfox.cloth.repositories.ClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WarehouseMainController {

  ClothRepository clothRepository;

  @Autowired
  public WarehouseMainController(ClothRepository clothRepository) {
    this.clothRepository = clothRepository;
  }

  @GetMapping("/warehouse")
  public String renderIndexPage(@ModelAttribute(name = "cloth") Cloth cloth, Model model) {
    model.addAttribute("clothes", clothRepository.findAll());
    model.addAttribute("uniqClothes", getUniqueCloth());
    return "index";
  }

  @PostMapping("/warehouse/summary")
  public String takesToSummary(@ModelAttribute Summary summary, Model model) {
    Cloth cloth = clothRepository.findFirstByItemName(summary.getItem());
      cloth.setSize(summary.getSize());
      model.addAttribute("cloth", cloth);
      model.addAttribute("quantity", summary.getQuantity());
      return "summary";
  }

  private List<String> getUniqueCloth() {
    return clothRepository
        .findAll()
        .stream()
        .map(Cloth::getItemName)
        .distinct()
        .collect(Collectors.toList());
  }

}

