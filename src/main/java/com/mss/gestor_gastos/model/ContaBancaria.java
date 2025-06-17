package com.mss.gestor_gastos.model;

import jakarta.persistence.*;
import lombok.Data;

//import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "contas_bancarias")
public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private String categoria;

    private Double saldoAtual;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnoreProperties("contasBancarias")
    private Usuario usuario;

    //@OneToMany(mappedBy = "contaBancaria", cascade = CascadeType.ALL)
    //@JsonIgnoreProperties("contasBancaria")
    //private List<Despesa> despesas;
}
