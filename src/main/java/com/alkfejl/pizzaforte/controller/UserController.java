package com.alkfejl.pizzaforte.controller;

import com.alkfejl.pizzaforte.entity.User;
import com.alkfejl.pizzaforte.repository.UserRepository;
import com.alkfejl.pizzaforte.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticatedUser actUser;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        Optional<User> oUser = userRepository.findByUsername(user.getUsername());
        if (oUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.ROLE_USER);
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("login")
        public ResponseEntity<User> login() {
            return ResponseEntity.ok(actUser.getUser());
        }
}
