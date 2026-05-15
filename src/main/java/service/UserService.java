package service;

import domain.Users;
import exceptions.UserNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    public Users createUsers(Users users){
        Users.persist(users);
        return users;
    }

    public List<Users> findAllUsers(Integer page, Integer pageSize){
        return Users.findAll()
                .page(page, pageSize)
                .list();
    }

    public Users findUserById(UUID userId){
        return (Users) Users.findByIdOptional(userId)
                .orElseThrow(UserNotFoundException::new);
    }
}
