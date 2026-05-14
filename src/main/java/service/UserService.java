package service;

import domain.Users;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

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
}
