package com.autocar.autocar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.autocar.autocar.models.entity.funcionario;

import com.autocar.autocar.models.repository.funcionarioRepository;

@Controller
@RequestMapping("/api")
public class funcionarioController {

    @Autowired
    private funcionarioRepository FuncionarioRepository;
    
    // Gerar tela de cadastro
    @GetMapping("/cadastro")
    public String Cadastro(){

        return "cadastro";
    }

    // Gerar tela de login
    @GetMapping("/login")
    public String login(){

        return "login";
    }

    // Cadastrar Funcionario
    @PostMapping("/cadastrar")
    public String cadastrar(funcionario Funcionario){
        FuncionarioRepository.save(Funcionario);

        return "redirect:/api/login";
    }

    // Credencial para acesso
    @PostMapping("/acessar")
    public String listarNomeESenha(@RequestParam String nome, String senha){
        funcionario Funcionario = FuncionarioRepository.FindByNomeAndSenha(nome, senha);

        if(Funcionario != null){    // Se houver valor no SELECT
            return "redirect:/api/carros";
        }else{
            return "redirect:/api/login";
        }
        
    } 

}
