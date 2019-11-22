package app.user.model;

import javax.persistence.*;

@Entity
@Table(name = "logs")
public class Logs {
    @Id
    @Column(name = "status")
    private boolean status;

    public Logs() {}

    public boolean getStatus() {return status;}

    public void setStatus(boolean status) {
        this.status = status;
    }
}
