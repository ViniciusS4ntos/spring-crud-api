package com.vinicius.spring_crud_api.controller;


import com.vinicius.spring_crud_api.business.UserService;
import com.vinicius.spring_crud_api.controller.dtos.UserDTORequest;
import com.vinicius.spring_crud_api.controller.dtos.UserDTOResponse;
import com.vinicius.spring_crud_api.infrastructure.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTOResponse> salvarUsuario(@RequestBody UserDTORequest user) {
        return ResponseEntity.ok(userService.salvarUsuario(user));
    }


}
