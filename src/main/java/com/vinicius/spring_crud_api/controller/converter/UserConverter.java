package com.vinicius.spring_crud_api.controller.converter;

import com.vinicius.spring_crud_api.controller.dtos.UserDTORequest;
import com.vinicius.spring_crud_api.controller.dtos.UserDTOResponse;
import com.vinicius.spring_crud_api.infrastructure.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    // Entity -> DTO

    public User paraEntity(UserDTORequest dto){
        return User.builder()
                .id(dto.getId())
                .email(dto.getEmail() != null ? dto.getEmail() : null)
                .nome(dto.getNome() != null ? dto.getNome() : null)
                .build();
    }


    // DTO Response -> Entity apenas quando for mostra para o usuario

    public UserDTOResponse paraDTO(User user){
        return UserDTOResponse.builder()
                .email(user.getEmail() != null ? user.getEmail() : null)
                .nome(user.getNome() != null ? user.getNome() : null)
                .build();
    }

    // Entity -> DTO Response
    public UserDTORequest paraDTORequest(User entity){
        return UserDTORequest.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .nome(entity.getNome())
                .build();
    }

    // DTO Request -> DTO Response
    public UserDTOResponse paraDTOResponse(UserDTORequest dto){
        return UserDTOResponse.builder()
                .email(dto.getEmail())
                .nome(dto.getNome())
                .build();
    }

}
