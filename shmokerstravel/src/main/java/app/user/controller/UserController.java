package app.user.controller;

import app.user.UserRepository;
import app.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public List<User> index() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User show(@PathVariable String id){
        int userId = Integer.parseInt(id);
        return userRepository.findOne(userId);
    }

    @PostMapping("/user")
    public User create(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String password = body.get("password");
        return userRepository.save(new User(email, password));
    }

    @PutMapping("/user/{id}")
    public User update(@PathVariable String id, @RequestBody Map<String, String> body){
        int userId = Integer.parseInt(id);
        String email = body.get("email");
        String password = body.get("password");
        User user = userRepository.findOne(userId);
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }

    @DeleteMapping("user/{id}")
    public boolean delete(@PathVariable String id){
        int userId = Integer.parseInt(id);
        userRepository.delete(userId);
        return true;
    }

}