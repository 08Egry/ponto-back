package com.example.controller.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.faces.annotation.RequestMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.dto.RegistroDto;
import com.example.controller.entity.Funcionario;
import com.example.controller.repository.RegistroRepository;
import com.example.controller.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistroController {

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private FuncionarioService  FuncionarioService;

    @PostMapping(value = "/registrar-ponto")
    public Funcionario registrarPonto(@RequestBody Funcionario funcionario) {
    
        return FuncionarioService.registrarPonto(funcionario.getNome(), funcionario.getMatricula());
    }

    @GetMapping(value="/registros")
    public ResponseEntity<List<Funcionario>> getRegEntity() {
        return ResponseEntity.status(HttpStatus.OK).body(registroRepository.findAll());
    }
}
