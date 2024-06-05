// package com.example.controller.service;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;

// @Configuration
// @Service
// public class CriptografarSenhas {

//     private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//     public String criptografar(String senha) {
//         return passwordEncoder.encode(senha);
//     }

//     public boolean matches(String rawPassword, String encodedPassword) {
//         return passwordEncoder.matches(rawPassword, encodedPassword);
//     }
// }
