package com.vinicius.spring_crud_api.business;

import com.vinicius.spring_crud_api.controller.dtos.in.UserDTORequest;
import com.vinicius.spring_crud_api.controller.dtos.out.UserDTOResponse;
import com.vinicius.spring_crud_api.controller.mapper.UserConverter;
import com.vinicius.spring_crud_api.infrastructure.entity.User;
import com.vinicius.spring_crud_api.infrastructure.exceptions.EmailExistenteException;
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
    public UserDTOResponse salvarUsuario(UserDTORequest dto) {

        verificarEmailExiste(dto.getEmail());

        User entity = userConverter.paraDTORequest(dto);

        return userConverter.paraDTO(userRepository.save(entity));
    }

    // Buscar Por email
    public UserDTOResponse buscarPorEmail(String email) {
        User entity = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Email nao encontrado"));
        return userConverter.paraDTO(entity);
    }

    // Deletar Por Email
    public void deletarPorEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    // Atualizar Por id
    public UserDTOResponse atualizarPorId(Long id, UserDTORequest dto) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id nao encontrado"));

        entity.setEmail(dto.getEmail() != null ? dto.getEmail() : entity.getEmail());
        entity.setNome(dto.getNome() != null ? dto.getNome() : entity.getNome());

        userRepository.save(entity);

        return userConverter.paraDTO(entity);
    }

    // Email existente no banco
    public Boolean existeEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new EmailExistenteException("Email existente no banco ");
        }
        return false;
    }

    // Verificar se existe no banco
    public void verificarEmailExiste(String email) {
        existeEmail(email);
    }

}
