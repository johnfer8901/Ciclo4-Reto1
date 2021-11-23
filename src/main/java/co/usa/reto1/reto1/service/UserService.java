package co.usa.reto1.reto1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto1.reto1.model.User;
import co.usa.reto1.reto1.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){

        return userRepository.getAll();
    }
    
    public Optional<User> getUser(int id){

        return userRepository.getUser(id);
    }

    public User save(User usr){

        if(usr.getId()==null){

            if (validarEmail(usr.getEmail()) == false){

                return userRepository.save(usr);
            }
            else {
                
                return usr;

            }
        }
        else {

            return usr;

        }

    }

    public boolean validarEmail (String email){

        return userRepository.validarEmail(email);


    }

    public User autenticacion (String email, String password){

        Optional<User> usr = userRepository.autenticacion(email, password);

        if (usr.isEmpty()) {

            return new User(email, password, "NO DEFINIDO");
            
        }

        else{

            return usr.get();
        }

    }

}
