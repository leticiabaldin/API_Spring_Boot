package com.example.project_api.controller;

import com.example.project_api.model.Projeto;
import com.example.project_api.service.ProjetoService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    // Metodo para criar um novo projeto
    @PostMapping
    public ResponseEntity<Projeto> criarProjeto(@Validated @RequestBody  Projeto projeto) {
        System.out.println("Projeto recebido: " + projeto);
        System.out.println("name:" + projeto.getName());
        System.out.println("description:" + projeto.getDescription());
        Projeto novoProjeto = projetoService.criarProjeto(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProjeto); // Retorna o novo projeto com status 201
    }

    // Metodo para listar todos os projetos
    @GetMapping
    public List<Projeto> listarProjetos() {
        return projetoService.listarProjetos();
    }

    //Busca pelo ID
    @GetMapping("/{id}")
    public Projeto buscarProjeto(@PathVariable Long id) {
        return projetoService.buscarProjetoPorId(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com o ID: " + id));
    }

    @DeleteMapping("/{id}")
    public void deletarProjeto(@PathVariable Long id) {
        projetoService.deletarProjeto(id);
    }
}
