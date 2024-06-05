package com.example.controller.service;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.controller.entity.Funcionario;
import com.example.controller.repository.RegistroRepository;



@Service
public class FuncionarioService  { 


    

    @Autowired
    private RegistroRepository registroRepository;


    public Funcionario registrarPonto(String nome, Integer matricula){
        Funcionario registro = new Funcionario();

        registro.setNome(nome);
        registro.setMatricula(matricula);
        registro.setHorarioChegada(LocalDateTime.now());
        


        return registroRepository.save(registro);

}

}
