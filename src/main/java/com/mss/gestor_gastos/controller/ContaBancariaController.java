package com.mss.gestor_gastos.controller;

import com.mss.gestor_gastos.model.ContaBancaria;
import com.mss.gestor_gastos.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contasBancarias")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @PostMapping
    public ContaBancaria salvar(@RequestBody ContaBancaria contaBancaria) {
        return contaBancariaService.salvar(contaBancaria);
    }

    @GetMapping
    public List<ContaBancaria> listarTodos() {
        return contaBancariaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<ContaBancaria> buscarPorId(@PathVariable Long id) {
        return contaBancariaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        contaBancariaService.deletar(id);
    }
}
