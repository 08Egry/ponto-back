package com.example.controller.service;

import com.example.controller.entity.Administrador;
import com.example.controller.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> findAll() {
        return administradorRepository.findAll();
    }

    public Administrador saveAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public Administrador findByNome(String nome) {
        return administradorRepository.findByNome(nome);
    }
    
}
