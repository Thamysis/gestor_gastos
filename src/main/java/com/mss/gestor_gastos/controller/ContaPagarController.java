package com.mss.gestor_gastos.controller;

import com.mss.gestor_gastos.model.ContaPagar;
import com.mss.gestor_gastos.service.ContaPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contasPagar")
@CrossOrigin(origins = "*")
public class ContaPagarController {

    @Autowired
    private ContaPagarService contaPagarService;

    @PostMapping
    public ContaPagar salvar(@RequestBody ContaPagar contaPagar) {
        return contaPagarService.salvar(contaPagar);
    }

    @GetMapping
    public List<ContaPagar> listar() {
        return contaPagarService.listarTodas();
    }

    @GetMapping("/{id}")
    public ContaPagar buscarPorId(@PathVariable Long id) {
        return contaPagarService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        contaPagarService.deletar(id);
    }
}
