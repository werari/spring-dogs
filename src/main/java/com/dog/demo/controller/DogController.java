package com.dog.demo.controller;

import com.dog.demo.dao.DogRepository;
import com.dog.demo.model.Dog;
import com.dog.demo.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Controller
public class DogController {

    private DogRepository dogRepository;
    private DogService dogService;

    @Autowired
    public DogController(DogRepository dogRepository, DogService dogService) {
        this.dogRepository = dogRepository;
        this.dogService = dogService;
    }

    @GetMapping("/")
    public String dogHome(Model model) {
        List<Dog> all = dogRepository.findAll();
        model.addAttribute("dogs", all);
        return "index";
    }

    @PostMapping("/")
    public String addDog(@RequestParam("name") String name, @RequestParam("rescued") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                         @RequestParam("vaccinated") Boolean vaccinated, Model model) {

        dogService.addDog(name, date, vaccinated);
        return "redirect:/";
    }
}
