package app.user.controller;

import app.ticket.TicketRepository;
import app.ticket.model.Ticket;
import app.user.UserRepository;
import app.user.model.User;
import app.session.SessionRepository;
import app.session.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    TicketRepository ticketRepository;

    @CrossOrigin
    @GetMapping("/user")
    public List<User> index() {
        return userRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/user/tickets/{hash}")
    public List<Object> getTickets(@PathVariable String hash) throws Error {
        int userId = 0;

        try{
            userId = sessionRepository.getUserId(hash);
        } catch (Error error) {
            throw new Error("unauthorized user");
        }

        return ticketRepository.findByUserId(userId);
    }

    @CrossOrigin
    @GetMapping("/user/{hash}")
    public User show(@PathVariable String hash){
        int userId = 0;
        try{
            userId = sessionRepository.getUserId(hash);
        } catch (Error error) {
            throw new Error("unauthorized user");
        }
        return userRepository.findOne(userId);
    }

    @CrossOrigin
    @GetMapping("/managers")
    public String[] show(){
        return userRepository.selectAllManagers();
    }

    @CrossOrigin
    @PostMapping("/user/create")
    public List<String> create(@RequestBody Map<String, String> body){
        String password = body.get("password");
        String phone = body.get("phone");
        String email = body.get("email");
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");

        User usr = userRepository.save(new User(password, phone, email, firstName, lastName));

        int userId = usr.getId();
        int hash = Session.makeHash((email));

        boolean isManager = false;
        String[] managers = userRepository.selectAllManagers();
        List<String> managersList = Arrays.asList(managers);
        if(managersList.contains(String.valueOf(userId))){
            isManager = true;
        }

        sessionRepository.save(new Session(hash, userId));

        List<String> out = new ArrayList<>();

        out.add(String.valueOf(hash));
        out.add(String.valueOf(isManager));

        return out;
    }

    @CrossOrigin
    @PostMapping("/user/update")
    public boolean update(@RequestBody Map<String, String> body) throws Error{

        String hash = body.get("hash");
        String password = body.get("password");
        String phone = body.get("phone");
        String email = body.get("email");
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");

        int userId = 0;
        try{
            userId = sessionRepository.getUserId(hash);
        } catch (Error error) {
            throw new Error("unauthorized user");
        }

        userRepository.updateUser(userId, password, phone, email, firstName, lastName);
        return true;
    }

    @CrossOrigin
    @PostMapping("/employee/update")
    public boolean updateEmployee(@RequestBody Map<String, String> body) throws Error{

        String hash = body.get("hash");
        int employeeId = Integer.parseInt(body.get("employeeId"));
        int salary = Integer.parseInt(body.get("salary"));

        int userId = 0;
        try{
            userId = sessionRepository.getUserId(hash);
        } catch (Error error) {
            throw new Error("unauthorized user");
        }

        String[] managers = userRepository.selectAllManagers();
        List<String> managersList = Arrays.asList(managers);
        if(managersList.contains(String.valueOf(userId))){
            userRepository.updateEmployee(employeeId, salary);
            return true;
        }else{
            throw new Error("user doesn't have priveliges");
        }
    }

    @CrossOrigin
    @PostMapping("/user/login")
    public List<String> login(@RequestBody Map<String, String> body){
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

        boolean isManager = false;
        String[] managers = userRepository.selectAllManagers();
        List<String> managersList = Arrays.asList(managers);
        System.out.println(managersList);
        if(managersList.contains(String.valueOf(userId))){
            isManager = true;
        }

        sessionRepository.save(new Session(hash, userId));

        List<String> out = new ArrayList<>();

        out.add(String.valueOf(hash));
        out.add(String.valueOf(isManager));

        return out;
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