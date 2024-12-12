package com.example.project_api.service;

import com.example.project_api.model.Projeto;

import com.example.project_api.model.Tarefa;
import com.example.project_api.repository.TarefaRepository;
import com.example.project_api.model.Status;

import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final ProjetoService projetoService;  // Declarar a variável projetoService

    // Modificar o construtor para inicializar a variável projetoService
    public TarefaService(TarefaRepository tarefaRepository, ProjetoService projetoService) {
        this.tarefaRepository = tarefaRepository;
        this.projetoService = projetoService;  // Atribuindo o ProjetoService à variável
    }

    public Tarefa criarTarefa(Long projetoId, Tarefa tarefa) {
        Projeto projeto = projetoService.buscarProjetoPorId(projetoId)  // Retorna Optional<Projeto>
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));  // Extrai o valor ou lança exceção
        tarefa.setProjeto(projeto);
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarStatus(Long id, Status status) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));
        tarefa.setStatus(status);
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
