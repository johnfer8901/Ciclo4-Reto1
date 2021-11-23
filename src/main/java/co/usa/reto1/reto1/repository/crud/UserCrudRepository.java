package co.usa.reto1.reto1.repository.crud;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.usa.reto1.reto1.model.User;

public interface UserCrudRepository extends CrudRepository<User, Integer>{

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
        
}
