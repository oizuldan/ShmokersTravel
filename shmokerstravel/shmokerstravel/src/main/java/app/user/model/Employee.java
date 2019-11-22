package app.user.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id_employee")
    private int employeeId;

    @Column(name = "salary")
    private int salary;

    @Column(name = "employment_date")
    private Date employmentDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    public Employee() {}

    public Employee(int employeeId, int salary, Date employmentDate) {
        this.employeeId = employeeId;
        this.salary = salary;
        this.employmentDate = employmentDate;
    }

    public int getEmployeeId(){return this.employeeId;}

    public int getSalary(){return this.salary;}

    public Date getEmploymentDate(){return this.employmentDate;}

    public String getFistName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmployeeId(int employeeId){this.employeeId = employeeId;}

    public void setSalary(int salary){this.salary = salary;}

    public void setEmploymentDate(Date employmentDate){this.employmentDate = employmentDate;}

    public void setFistName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "employeeId='" + employeeId + '\'' +
                "salary='" + salary + '\'' +
                "employmentDate='" + employmentDate + '\'' +
                "firstName='" + firstName + '\'' +
                "lastName='" + lastName + '\'' +
                '}';
    }
}
