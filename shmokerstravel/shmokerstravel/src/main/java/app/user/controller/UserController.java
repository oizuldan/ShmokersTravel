package app.user.controller;

import app.user.UserRepository;
import app.user.model.User;
import app.session.SessionRepository;
import app.session.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionRepository sessionRepository;

    @CrossOrigin
    @GetMapping("/user")
    public List<User> index() {
        return userRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/user/{id}")
    public User show(@PathVariable String id){
        int userId = Integer.parseInt(id);
        return userRepository.findOne(userId);
    }

    @CrossOrigin
    @PostMapping("/user/create")
    public Session create(@RequestBody Map<String, String> body){
        String password = body.get("password");
        String phone = body.get("phone");
        String email = body.get("email");
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");

        User usr = userRepository.save(new User(password, phone, email, firstName, lastName));

        int userId = usr.getId();
        int hash = Session.makeHash((email));


        Session ssn = sessionRepository.save(new Session(hash, userId));

        return ssn;
    }

    @CrossOrigin
    @PostMapping("/user/login")
    public Session login(@RequestBody Map<String, String> body){
        String password = body.get("password");
        String email = body.get("email");

        List<User> usr = userRepository.findAll()
                .stream()
                .filter(s -> s.getEmail().equals(email)
                        && s.getPassword().equals(password))
                .collect(Collectors.toList());

        if(usr.size() == 0) return null;
        int userId = usr.get(0).getId();
        int hash = Session.makeHash((email));


        Session ssn = sessionRepository.save(new Session(hash, userId));

        return ssn;
    }

    @CrossOrigin
    @PutMapping("/user/{id}")
    public User update(@PathVariable String id, @RequestBody Map<String, String> body){
        int userId = Integer.parseInt(id);
        String password = body.get("password");
        String phone = body.get("phone");
        String email = body.get("email");
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");

        User user = userRepository.findOne(userId);

        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        return userRepository.save(user);
    }

    @CrossOrigin
    @DeleteMapping("user/{id}")
    public boolean delete(@PathVariable String id){
        int userId = Integer.parseInt(id);
        userRepository.delete(userId);

        return true;
    }

    @CrossOrigin
    @DeleteMapping("user/logout/{hash}")
    public boolean logout(@PathVariable String hash){
        sessionRepository.deleteSession(hash);

        return true;
    }

}