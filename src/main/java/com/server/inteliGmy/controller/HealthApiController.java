package com.server.inteliGmy.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthApiController {

    @GetMapping()
    public ResponseEntity<String> getHealth() {
        // Verifique o estado da sua aplicação aqui
        // Se a aplicação estiver operacional, retorne um status 200 OK
        // Se houver um problema, retorne um status diferente (por exemplo, 500 para Erro Interno do Servidor)

        return ResponseEntity.ok("Ok!");
    }
}

