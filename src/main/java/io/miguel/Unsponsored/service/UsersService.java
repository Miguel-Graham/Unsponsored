package io.miguel.Unsponsored.service;

import io.miguel.Unsponsored.model.UsersModel;
import io.miguel.Unsponsored.repsitory.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersModel registerUser(String login, String password, String email){
        if (login == null || password == null) {
            return null;
        } else {
            if (usersRepository.findFirstByLoginAndEmail(login, email).isPresent()){
                System.out.println("This username or email is already taken");
                return null;

            }
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setEmail(email);
            usersModel.setPassword(password);
            return usersRepository.save(usersModel);
        }

    }
    public UsersModel authenticate (String login, String password){
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
