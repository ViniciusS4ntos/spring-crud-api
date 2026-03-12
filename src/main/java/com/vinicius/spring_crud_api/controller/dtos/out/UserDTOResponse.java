package com.vinicius.spring_crud_api.controller.dtos.out;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserDTOResponse {

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nome")
    private String nome;

}
