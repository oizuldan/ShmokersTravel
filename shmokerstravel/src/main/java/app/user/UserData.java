package app.user;

import app.user.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    //list of blog posts
    private List<User> users;

    private static UserData instance = null;
    public static UserData getInstance(){
        if(instance == null){
            instance = new UserData();
        }
        return instance;
    }


    public UserData(){
        users = new ArrayList<User>();
        users.add(new User(1, "aisultan.kassenov@nu.edu.kz", "123456789"));
        users.add(new User(2, "alinur.amangazy@nu.edu.kz", "123456789"));
    }

    // return all
    public List<User> fetchUsers() {
        return users;
    }

    // return user by email
    public User getUserById(int id) {
        for(User user: users) {
            if(user.getId() == id) {
                return user;
            }
        }

        return null;
    }


    // create user
    public User createUser(int id, String email, String password) {
        User newUser = new User(id, email, password);
        users.add(newUser);

        return newUser;
    }

    // update user
    public User updateUser(int id, String email, String password) {
        for(User user: users) {
            if(user.getId() == id) {
                int userIndex = users.indexOf(user);

                user.setEmail(email);
                user.setPassword(password);
                users.set(userIndex, user);

                return user;
            }

        }

        return null;
    }

    // delete blog by id
    public boolean delete(int id){
        int userIndex = -1;
        for(User user: users) {
            if(user.getId() == id) {
                userIndex = users.indexOf(user);
                continue;
            }
        }
        if(userIndex > -1){
            users.remove(userIndex);
        }
        return true;
    }

}
