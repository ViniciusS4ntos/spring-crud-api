package com.vinicius.spring_crud_api.controller.dtos.out;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserDTOResponse {

    private Long id;
    private String email;
    private String nome;

}
