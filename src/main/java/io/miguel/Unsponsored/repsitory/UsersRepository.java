package io.miguel.Unsponsored.repsitory;

import io.miguel.Unsponsored.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {
    Optional<UsersModel> findByLoginAndPassword(String login, String password);
    Optional<UsersModel>findFirstByLoginAndEmail(String login, String email);
}