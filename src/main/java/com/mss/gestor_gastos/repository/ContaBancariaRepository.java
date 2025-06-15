package com.mss.gestor_gastos.repository;

import com.mss.gestor_gastos.model.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
}
