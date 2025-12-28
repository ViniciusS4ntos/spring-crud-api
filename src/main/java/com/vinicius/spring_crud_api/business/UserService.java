package com.vinicius.spring_crud_api.business;

import com.vinicius.spring_crud_api.infrastructure.entity.User;
import com.vinicius.spring_crud_api.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;


    public UserService (UserRepository repository){
        this.repository = repository;
    }



    // SALVAR USER
    public void saveUser(User user){
        repository.saveAndFlush(user); // salva e fechar a conexao com o banco
    }

    // BUSCAR USER
    public User findUserByEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email nao encontrado!")
        );
    }

    // DELETAR USER
    public void deleteByEmail(String email){
        repository.deleteByEmail(email);
    }

    // ATUALIZAR USER
    public void updateById(Integer id, User user){

        User entityUser = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id nao encontrado!")
        );
        User userUpdate = User.builder()
                .email(user.getEmail() != null ?
                        user.getEmail() : entityUser.getEmail())
                .nome(user.getNome() != null ?
                        user.getNome() : entityUser.getNome())
                .id(entityUser.getId())
                .build();

        repository.saveAndFlush(userUpdate);
    }
}
