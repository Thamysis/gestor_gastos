package com.mss.gestor_gastos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "receitas")
public class Receita {

    public enum Categoria {
        SALARIO,
        RENDIMENTOS,
        INVESTIMENTOS,
        VENDAS,
        REEMBOLSOS,
        OUTROS
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Double valor;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnoreProperties("receitas")
    private Usuario usuario;
}
