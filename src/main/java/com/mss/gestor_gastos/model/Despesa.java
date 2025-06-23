package com.mss.gestor_gastos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "despesas")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private CategoriaDespesa categoria;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    private Double valor;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnoreProperties("despesas")
    private Usuario usuario;

    //@ManyToOne
    //@JoinColumn(name = "conta_bancaria_id")
    //@JsonIgnoreProperties("despesas")
    //private ContaBancaria contaBancaria;

    public enum FormaPagamento {
        DINHEIRO,
        CARTAO_CREDITO,
        CARTAO_DEBITO,
        PIX,
        TRANSFERENCIA_BANCARIA,
        BOLETO
    }

    public enum CategoriaDespesa {
        ALIMENTACAO,
        MORADIA,
        TRANSPORTE,
        LAZER,
        SAUDE,
        EDUCACAO
    }
}
