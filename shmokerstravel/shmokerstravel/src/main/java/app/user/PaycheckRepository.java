package app.user;

import app.user.model.Paycheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaycheckRepository extends JpaRepository<Paycheck, Integer>
{
}
