package com.vinicius.spring_crud_api.controller;

import com.vinicius.spring_crud_api.business.UserService;
import com.vinicius.spring_crud_api.controller.dtos.in.UserDTORequest;
import com.vinicius.spring_crud_api.controller.dtos.out.UserDTOResponse;
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

    @GetMapping
    public ResponseEntity<UserDTOResponse> buscarPorEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(userService.buscarPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarPorEmail(@RequestParam("email") String email) {
        userService.deletarPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UserDTOResponse> atualizaPorId(@RequestParam("id") Long id,
                                                         @RequestBody UserDTORequest dto) {
        return ResponseEntity.ok(userService.atualizarPorId(id, dto));
    }
}
