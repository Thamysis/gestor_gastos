package com.mss.gestor_gastos.controller;

import com.mss.gestor_gastos.dto.LoginDTO;
import com.mss.gestor_gastos.model.Usuario;
import com.mss.gestor_gastos.repository.UsuarioRepository;
import com.mss.gestor_gastos.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginDTO loginDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findAll().stream()
                .filter(u -> u.getEmail().equals(loginDTO.getEmail()))
                .findFirst();

        if (usuarioOpt.isPresent() && passwordEncoder.matches(loginDTO.getSenha(), usuarioOpt.get().getSenha())) {
            String token = jwtUtil.generateToken(loginDTO.getEmail());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("id", usuarioOpt.get().getId().toString());
            return response;
        }
        throw new RuntimeException("Credenciais inválidas");
    }
}