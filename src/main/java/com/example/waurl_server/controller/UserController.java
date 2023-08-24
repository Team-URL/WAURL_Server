package com.example.waurl_server.controller;
import com.example.waurl_server.entity.User;
import com.example.waurl_server.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/join")
    public boolean signUp(@RequestParam("email") String email, @RequestParam("passWord") String passWord) {
        Optional<User> findUser = userRepository.findByEmail(email);
        if (!findUser.isEmpty()) {
            return false;
        } else {
            User joinUser = new User(email, passWord);
            userRepository.save(joinUser);
            return true;
        }
    }

    @PostMapping("/login")
    public boolean signIn(@RequestParam("email") String email, @RequestParam("passWord") String passWord){
        Optional<User> loginUser = userRepository.findByEmail(email);
        if(loginUser.isPresent() && loginUser.get().getPassWord().equals(passWord))
            return true;
        else
            return false;
    }
}
