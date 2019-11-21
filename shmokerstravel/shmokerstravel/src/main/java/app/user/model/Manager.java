package app.user.model;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @Column(name = "id_manager")
    private int managerId;


    public Manager() {}

    public Manager(int id) {
        this.setId(id);
    }

    public int getId() {
        return managerId;
    }

    public void setId(int id) {
        managerId = id;
    }


    @Override
    public String toString() {
        return "User{" +
                "managerId='" + managerId + '\'' +
                '}';
    }
}
