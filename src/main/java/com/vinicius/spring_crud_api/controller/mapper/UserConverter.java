package com.vinicius.spring_crud_api.controller.mapper;

import com.vinicius.spring_crud_api.controller.dtos.in.UserDTORequest;
import com.vinicius.spring_crud_api.controller.dtos.out.UserDTOResponse;
import com.vinicius.spring_crud_api.infrastructure.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    //Entity -> DTOResponse
    public UserDTOResponse paraDTO(User user){
        return UserDTOResponse.builder()
                .email(user.getEmail() != null ? user.getEmail() : null)
                .nome(user.getNome() != null ? user.getNome() : null)
                .build();
    }

    // Request -> entity
    public User paraDTORequest(UserDTORequest entity){
        return User.builder()
                .email(entity.getEmail())
                .nome(entity.getNome())
                .build();
    }


}
