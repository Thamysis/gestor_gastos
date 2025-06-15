package com.mss.gestor_gastos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String senha;

    private Double saldoInicial;

    private Double saldoAtual;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Despesa> despesas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Receita> receitas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ContaBancaria> contasBancarias;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ContaPagar> contasPagar;
}
