package app.user.controller;

import app.user.UserData;
import app.user.UserRepository;
import app.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userData;

    @GetMapping("/user")
    public List<User> index() {
        return userData.findAll();
    }

    @GetMapping("/user/{id}")
    public User show(@PathVariable String id){
        int userId = Integer.parseInt(id);
        return userData.findOne(userId);
    }

    @PostMapping("/user")
    public User create(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String password = body.get("password");
        return userData.save(new User(email, password));
    }

    @PutMapping("/user/{id}")
    public User update(@PathVariable String id, @RequestBody Map<String, String> body){
        int userId = Integer.parseInt(id);
        String email = body.get("email");
        String password = body.get("password");
        User user = userData.findOne(userId);
        user.setEmail(email);
        user.setPassword(password);
        return userData.save(user);
    }

    @DeleteMapping("user/{id}")
    public boolean delete(@PathVariable String id){
        int userId = Integer.parseInt(id);
        userData.delete(userId);
        return true;
    }

}