package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Usuario;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Validated LoginRequest request) {
        String token = authService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(new LoginResponse(token, "Bearer", request.getEmail()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Validated Usuario usuario,
                                      @RequestParam(defaultValue = "false") boolean admin) {
        Usuario creado = authService.registerUsuario(usuario, admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}
