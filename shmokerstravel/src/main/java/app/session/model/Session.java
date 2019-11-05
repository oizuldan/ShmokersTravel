package app.session.model;

import javax.persistence.*;

@Entity
@Table(name = "Session")
public class Session {

    @Id
    @Column(name = "hash")
    private String hash;

    @Column(name = "user_id")
    private int userId;

    public Session() { }

    public Session(int hash, int userId) {
        this.hash = String.valueOf(hash);
        this.userId = userId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static int makeHash(String str){
        int hash = 7;
        for (int i = 0; i < str.length(); i++) {
            hash = hash * 31 + str.charAt(i);
        }
        return hash;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
