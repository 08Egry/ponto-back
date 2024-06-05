package com.example.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.controller.entity.Administrador;
import com.example.controller.entity.Funcionario;
import com.example.controller.repository.RegistroRepository;
import com.example.controller.service.AdministradorService;
// import com.example.controller.service.CriptografarSenhas;

import javax.servlet.http.HttpSession;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/autenticacao")
public class AdministradorController {

    private static final Logger logger = LoggerFactory.getLogger(AdministradorController.class);

    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private RegistroRepository registroRepository;

    // @Autowired
    // private CriptografarSenhas criptografarSenhas;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String nome, @RequestParam String password, HttpSession session) {
        logger.info("Tentativa de login com o nome de usuário: " + nome);
        
        Administrador administrador = administradorService.findByNome(nome);

        if (administrador == null) {
            logger.error("Usuário não encontrado: " + nome);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
        
        // if (!criptografarSenhas.matches(password, administrador.getSenha())) {
        //     logger.error("Senha incorreta para o usuário: " + nome);
        //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        // }
        
        session.setAttribute("user", administrador);
        return ResponseEntity.ok(administrador);
    }

    @GetMapping("/perfil")
    public ResponseEntity<List<Funcionario>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(registroRepository.findAll());
    }

    @PostMapping("/criar-usuario")
    public ResponseEntity<Administrador> createAdministrador(@RequestBody Administrador administrador) {
        // administrador.setSenha(criptografarSenhas.criptografar(administrador.getSenha()));
        Administrador savedAdmin = administradorService.saveAdministrador(administrador);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdmin);
    }
}
