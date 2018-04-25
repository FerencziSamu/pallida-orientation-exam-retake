package com.greenfox.cloth.controllers;

import com.greenfox.cloth.models.Cloth;
import com.greenfox.cloth.repositories.ClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    model.addAttribute("cloth", new Cloth());
    return "index";
  }

  @PostMapping("/warehouse/summary")
  public String takesToSummary(@ModelAttribute(name = "cloth") Cloth cloth, Model model,
                                  @RequestParam(name = "quantity") int quantity) {
    model.addAttribute("cloth", cloth);
    model.addAttribute("quantity",quantity);
    return "redirect:/warehouse/summary";
  }

  @GetMapping("/warehouse/summary")
  public String loadsSummaryPage(@ModelAttribute(name = "cloth") Cloth cloth, Model model) {
    model.addAttribute("cloth",cloth);
    return "summary";
  }


}
