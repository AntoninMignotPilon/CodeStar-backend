package com.codestar.backend.controller;

import com.codestar.backend.dto.LoginRequestDto;
import com.codestar.backend.dto.LoginResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request){

        if("admin".equals(request.getUsername()) && "password".equals(request.getPassword())){
            return ResponseEntity.ok(new LoginResponseDto("123456789", "Connexion réussie"));
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
