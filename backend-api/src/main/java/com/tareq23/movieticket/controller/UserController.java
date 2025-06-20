package com.tareq23.movieticket.controller;

import com.tareq23.movieticket.dto.request.UserRegisterRequest;
import com.tareq23.movieticket.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterRequest registerRequest) {
        return ResponseEntity.ok(userService.addNewUser(registerRequest));
    }

}
