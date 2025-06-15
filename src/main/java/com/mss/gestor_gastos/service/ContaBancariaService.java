package com.mss.gestor_gastos.service;

import com.mss.gestor_gastos.model.ContaBancaria;
import com.mss.gestor_gastos.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public ContaBancaria salvar(ContaBancaria conta) {
        return contaBancariaRepository.save(conta);
    }

    public List<ContaBancaria> listarTodos() {
        return contaBancariaRepository.findAll();
    }

    public Optional<ContaBancaria> buscarPorId(Long id) {
        return contaBancariaRepository.findById(id);
    }

    public void deletar(Long id) {
        contaBancariaRepository.deleteById(id);
    }
}
