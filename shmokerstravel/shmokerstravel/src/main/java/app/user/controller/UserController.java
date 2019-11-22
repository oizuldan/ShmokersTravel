package app.user.controller;

import app.MainApplication;
import app.ticket.TicketRepository;
import app.ticket.model.Ticket;
import app.user.LogsRepository;
import app.user.UserRepository;
import app.user.model.Employee;
import app.user.model.User;
import app.session.SessionRepository;
import app.session.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    LogsRepository logsRepository;

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
    @GetMapping("/getAgents")
    public List<Employee> getAgents(){

        List<Employee> agents = new ArrayList<>();
        List<Object[]> res = userRepository.findAgents();
        Iterator it = res.iterator();

        while(it.hasNext()){
            Object[] line = (Object[]) it.next();
            Employee agent = new Employee();

            agent.setEmployeeId((int) line[0]);
            agent.setSalary((int) line[1]);
            agent.setEmploymentDate((Date) line[2]);
            agent.setFistName((String) line[3]);
            agent.setLastName((String) line[4]);

            agents.add(agent);
        }

        return agents;
    }

    @CrossOrigin
    @GetMapping("/managers")
    public String[] show(){
        return userRepository.selectAllManagers();
    }

    @CrossOrigin
    @GetMapping("/logs")
    public String getLogs() throws IOException {

        String content = new String ( Files.readAllBytes( Paths.get("/Users/icett/Desktop/NU/3year_1stSem/SWE/ShmokersTravel/shmokerstravel/shmokerstravel/logs.txt") ) );

        return content;
    }

    @CrossOrigin
    @PostMapping("/user/create")
    public List<String> create(@RequestBody Map<String, String> body) throws IOException {
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


        if(logsRepository.findAll().get(0).getStatus()){
            File file = new File("/Users/icett/Desktop/NU/3year_1stSem/SWE/ShmokersTravel/shmokerstravel/shmokerstravel/logs.txt");
            FileWriter fr = new FileWriter(file, true);
            String output = "User Created: userId -> " + userId + " ----- date -> " + new Date() + "\n";

            fr.write(output);
            fr.close();
        }

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
    public boolean updateEmployee(@RequestBody Map<String, String> body) throws Error, IOException {

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

            if(logsRepository.findAll().get(0).getStatus()) {
                File file = new File("/Users/icett/Desktop/NU/3year_1stSem/SWE/ShmokersTravel/shmokerstravel/shmokerstravel/logs.txt");
                FileWriter fr = new FileWriter(file, true);
                String output = "Employee Updated: userId -> " + employeeId + " ----- date -> " + new Date() + "\n";

                fr.write(output);
                fr.close();
            }

            return true;
        }else{
            throw new Error("user doesn't have priveliges");
        }


    }

    @CrossOrigin
    @PostMapping("/logs/{enabled}")
    public void updateEmployee(@PathVariable String enabled) throws Error{
        logsRepository.updateLogs(Boolean.valueOf(enabled));
    }

    @CrossOrigin
    @PostMapping("/user/login")
    public List<String> login(@RequestBody Map<String, String> body) throws IOException {
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

        if(managersList.contains(String.valueOf(userId))){
            isManager = true;
        }

        sessionRepository.save(new Session(hash, userId));

        List<String> out = new ArrayList<>();

        out.add(String.valueOf(hash));
        out.add(String.valueOf(isManager));

        if(logsRepository.findAll().get(0).getStatus()) {
            File file = new File("/Users/icett/Desktop/NU/3year_1stSem/SWE/ShmokersTravel/shmokerstravel/shmokerstravel/logs.txt");
            FileWriter fr = new FileWriter(file, true);
            String output = "User LoggedIn: userId -> " + userId + " ----- date -> " + new Date() + "\n";

            fr.write(output);
            fr.close();
        }

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
    public boolean logout(@PathVariable String hash) throws IOException {
        int userId = sessionRepository.getUserId(hash);

        sessionRepository.deleteSession(hash);

        if(logsRepository.findAll().get(0).getStatus()) {
            File file = new File("/Users/icett/Desktop/NU/3year_1stSem/SWE/ShmokersTravel/shmokerstravel/shmokerstravel/logs.txt");
            FileWriter fr = new FileWriter(file, true);
            String output = "User LoggedOut: userId -> " + userId + " ----- date -> " + new Date() + "\n";

            fr.write(output);
            fr.close();
        }

        return true;
    }

}