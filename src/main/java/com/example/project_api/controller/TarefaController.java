package com.example.project_api.controller;

import com.example.project_api.model.Status;
import com.example.project_api.model.Tarefa;
import com.example.project_api.service.TarefaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/{projetoId}")
    public Tarefa criarTarefa(@PathVariable Long projetoId, @RequestBody Tarefa tarefa) {
        return tarefaService.criarTarefa(projetoId, tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarStatus(@PathVariable Long id, @RequestParam Status status) {
        return tarefaService.atualizarStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
    }
}
