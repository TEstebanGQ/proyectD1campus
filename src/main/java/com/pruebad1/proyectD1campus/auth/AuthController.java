package com.pruebad1.proyectD1campus.auth;

import com.pruebad1.proyectD1campus.config.JwtService;
import com.pruebad1.proyectD1campus.dto.request.LoginRequest;
import com.pruebad1.proyectD1campus.exception.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        if (request.username().equals("admin") &&
                request.password().equals("1234")) {

            String token = jwtService.generateToken(request.username());

            /**
             * {
             *  "token": "212rwerewr.122343wrhbu43iu4.uiqg3v12yu4g27984y84y12guib4"
             * }
             * */
            return Map.of("token", token);
        }

        throw new BusinessRuleException("Credenciales inválidas");
    }
}
