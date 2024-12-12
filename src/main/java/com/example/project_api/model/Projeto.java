package com.example.project_api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity // Entidade do JPA
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // valor gerado no banco
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();

    // Relacionamento 1 -> muitos (um projeto pode ter várias tarefas)
    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarefa> task;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Tarefa> getTask() {
        return task;
    }

    public void setTask(List<Tarefa> task) {
        this.task = task;
    }

    // Override toString para uma representação mais legível
    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", task=" + task +
                '}';
    }
}
