package app.session.controller;

import app.session.SessionRepository;
import app.session.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SessionController {

    @Autowired
    SessionRepository sessionRepository;

    @CrossOrigin
    @GetMapping("/session")
    public List<Session> index() {
        return sessionRepository.findAll();
    }


    @CrossOrigin
    @GetMapping("/session/{hash}")
    public int show(@PathVariable String hash){
        return sessionRepository.getUserId(hash);
    }

    @CrossOrigin
    @PostMapping("/session")
    public Session create(@RequestBody Map<String, String> body){
        int hash = Session.makeHash((body.get("email")));
        int user_id = Integer.parseInt(body.get("user_id"));

        System.out.println(user_id + " " + hash);
        return sessionRepository.save(new Session(hash, user_id));

    }

    @CrossOrigin
    @DeleteMapping("session/{hash}")
    public boolean delete(@PathVariable String hash){
        sessionRepository.deleteSession(hash);
        return true;
    }

}