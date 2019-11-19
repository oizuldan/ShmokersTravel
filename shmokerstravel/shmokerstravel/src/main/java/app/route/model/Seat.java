package app.route.model;

import javax.persistence.*;

@Entity
@Table(name = "seat")
@IdClass(SeatKeys.class)
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_number")
    private int seatNumber;

    @Id
    @Column(name = "vagon_number")
    private int vagonNumber;

    @Id
    @Column(name = "train_number")
    private int trainNumber;

    public Seat() {}

    public Seat(int seatNumber, int vagonNumber, int trainNumber) {
        this.seatNumber = seatNumber;
        this.vagonNumber = vagonNumber;
        this.trainNumber = trainNumber;
    }

    public int getSeatNumber() {return seatNumber;}
    public int getVagonNumber() {return vagonNumber;}
    public int getTrainNumber() {return trainNumber;}

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber+ "'" +
                "vagonNumber='" + vagonNumber + "'" +
                "trainNumber='" + trainNumber + "'}";
    }
}
