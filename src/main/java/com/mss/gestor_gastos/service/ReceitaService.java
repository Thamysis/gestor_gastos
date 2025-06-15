package com.mss.gestor_gastos.service;

import com.mss.gestor_gastos.model.Receita;
import com.mss.gestor_gastos.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita salvar(Receita receita) {
        return receitaRepository.save(receita);
    }

    public List<Receita> listarTodas() {
        return receitaRepository.findAll();
    }

    public Receita buscarPorId(Long id) {
        return receitaRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        receitaRepository.deleteById(id);
    }
}
