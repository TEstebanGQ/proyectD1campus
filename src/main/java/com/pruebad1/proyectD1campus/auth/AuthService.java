package com.pruebad1.proyectD1campus.auth;

import com.pruebad1.proyectD1campus.config.JwtService;
import com.pruebad1.proyectD1campus.exception.InvalidCredentialsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;

    public AuthResponse authenticate(AuthRequest request) {
        if (request.getUsername() == null || request.getUsername().isBlank() ||
                request.getPassword() == null || request.getPassword().isBlank()) {
            throw new InvalidCredentialsException("Nombre de usuario o contraseña inválidos");
        }

        String token = jwtService.generateToken(request.getUsername());

        return AuthResponse.builder()
                .token(token)
                .tokenType("Bearer")
                .username(request.getUsername())
                .build();
    }
}
