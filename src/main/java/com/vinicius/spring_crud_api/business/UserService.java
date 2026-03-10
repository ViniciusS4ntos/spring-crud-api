package com.vinicius.spring_crud_api.business;

import com.vinicius.spring_crud_api.controller.converter.UserConverter;
import com.vinicius.spring_crud_api.controller.dtos.UserDTORequest;
import com.vinicius.spring_crud_api.controller.dtos.UserDTOResponse;
import com.vinicius.spring_crud_api.infrastructure.entity.User;
import com.vinicius.spring_crud_api.infrastructure.exceptions.ResourceNotFoundException;
import com.vinicius.spring_crud_api.infrastructure.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    // Salvar
    public UserDTOResponse salvarUsuario(UserDTORequest dto){

        User entity = userConverter.paraEntity(dto);
        userRepository.save(entity);

        return userConverter.paraDTOResponse(dto);
    }

    // Buscar Por email
    public UserDTOResponse buscarPorEmail(String email){
        User entity = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Email nao encontrado"));
        return userConverter.paraDTO(entity);
    }

    // Deletar Por Email
    public void deletarPorEmail(String email){
        userRepository.deleteByEmail(email);
    }
    
    // Atualizar Por id
    public UserDTOResponse atualizarPorId(Long id, UserDTORequest dto){
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id nao encontrado"));

        entity.setEmail(dto.getEmail() != null ? dto.getEmail() : entity.getEmail());
        entity.setNome(dto.getNome() != null ? dto.getNome() : entity.getNome());

        userRepository.save(entity);

        return userConverter.paraDTO(entity);

    }

}
