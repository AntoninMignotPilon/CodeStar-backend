package com.codestar.backend.controller;

import com.codestar.backend.dto.LoginRequestDto;
import com.codestar.backend.dto.LoginResponseDto;
import com.codestar.backend.model.User;
import com.codestar.backend.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthController(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request){

        Optional<User> userOptionnal = userRepository.findByUsername(request.getUsername());

        if (userOptionnal.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User user = userOptionnal.get();
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())){
            return ResponseEntity.ok(new LoginResponseDto("123456789", "Connexion réussie"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nom d'utilisateur non disponible");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Compte créé");
    }



}





































