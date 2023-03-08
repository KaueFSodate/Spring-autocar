package com.autocar.autocar.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autocar.autocar.models.entity.carro;
import com.autocar.autocar.models.repository.carroRepository;

@Controller
@RequestMapping("/api")
public class carroController {

    @Autowired
    private carroRepository CarroRepository;

    // Tela de carros em conjunto com os carros adicionados
    @GetMapping("/carros")
    public String carros(Model model){
        
        Iterable<carro> Carros = CarroRepository.findAll();
        model.addAttribute("carro", Carros);
        return "carro";
    }

    @PostMapping("/cadastrarcarros")
    public String cadastrar(carro Carro){
        CarroRepository.save(Carro);
        return "redirect:/api/carros";
    }

    @GetMapping("/deletar{id}")
    public String cadastrar(@PathVariable int id){
        CarroRepository.deleteById(id);
        return "redirect:/api/carros";
    }

    // Tela para editar
    @GetMapping("/alterar{id}")
    public String alterar(@PathVariable int id, Model model){
        Optional<carro> Carros = CarroRepository.findById(id);
        model.addAttribute("carro", Carros.get());
        return "editar";
    }

    // Editar carro
    @PostMapping("/editar{id}")
    public String editar(carro Carro){
        CarroRepository.save(Carro);
        return "redirect:/api/carros";
    }




}
