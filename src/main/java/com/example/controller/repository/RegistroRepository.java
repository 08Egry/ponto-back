package com.example.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.controller.entity.Funcionario;

public interface RegistroRepository extends JpaRepository<Funcionario, Long> {

}
