package app.user.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "paycheck")
public class Paycheck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "amount")
    private int amount;

    @Column(name = "date")
    private Date date;

    public Paycheck() {}

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Paycheck{" +
                "id='" + id + '\'' +
                "userId='" + userId + '\'' +
                "amount='" + amount + '\'' +
                "date='" + date + '\'' +
                '}';
    }
}
