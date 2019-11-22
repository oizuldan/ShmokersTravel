package app.user;

import app.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByEmail(String email);

    @Query("select E.employeeId, E.salary, E.employmentDate, E.firstName, E.lastName\n" +
            "from Employee E where E.employeeId not in (select managerId from Manager)")
    List<Object[]> findAgents();

    @Transactional
    @Modifying
    @Query("update User u set u.email = :email, u.password = :password, u.firstName = :firstName, u.lastName = :lastName," +
            "u.password = :password, u.phone = :phone where u.id = :userId")
    void updateUser(@Param("userId") int userId, @Param("password") String password, @Param("phone") String phone,
                    @Param("email") String email, @Param("firstName") String firstName, @Param("lastName") String lastName);

    @Transactional
    @Modifying
    @Query("update Employee e set e.salary = :salary where e.employeeId = :employeeId")
    void updateEmployee(@Param("employeeId") int employeeId, @Param("salary") int salary);

    @Query("select m.managerId from Manager m")
    String[] selectAllManagers();

}
