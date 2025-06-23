package com.mss.gestor_gastos.controller;

import com.mss.gestor_gastos.model.Receita;
import com.mss.gestor_gastos.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas")
@CrossOrigin(origins = "*")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    public Receita salvar(@RequestBody Receita receita) {
        return receitaService.salvar(receita);
    }

    @GetMapping
    public List<Receita> listar() {
        return receitaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Receita buscarPorId(@PathVariable Long id) {
        return receitaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        receitaService.deletar(id);
    }
}
