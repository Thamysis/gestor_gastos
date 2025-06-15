package com.mss.gestor_gastos.service;

import com.mss.gestor_gastos.model.ContaPagar;
import com.mss.gestor_gastos.repository.ContaPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaPagarService {

    @Autowired
    private ContaPagarRepository contaPagarRepository;

    public ContaPagar salvar(ContaPagar contaPagar) {
        return contaPagarRepository.save(contaPagar);
    }

    public List<ContaPagar> listarTodas() {
        return contaPagarRepository.findAll();
    }

    public ContaPagar buscarPorId(Long id) {
        return contaPagarRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        contaPagarRepository.deleteById(id);
    }
}
