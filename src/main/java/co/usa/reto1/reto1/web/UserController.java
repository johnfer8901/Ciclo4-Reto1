package co.usa.reto1.reto1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.reto1.reto1.model.User;
import co.usa.reto1.reto1.service.UserService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){

        return userService.getAll();
        
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User usr){

        return userService.save(usr);
    }

    @GetMapping("/{email}/{password}")
    public User autenticacion(@PathVariable("email") String email, @PathVariable("password") String password){

        return userService.autenticacion(email, password);
    }

    @GetMapping("/{email}")
    public boolean validarEmail(@PathVariable("email") String email){

        return userService.validarEmail(email);
    }

    
}
