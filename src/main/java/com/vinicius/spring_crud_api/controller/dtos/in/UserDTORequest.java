package com.vinicius.spring_crud_api.controller.dtos.in;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserDTORequest {

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nome")
    private String nome;
}
