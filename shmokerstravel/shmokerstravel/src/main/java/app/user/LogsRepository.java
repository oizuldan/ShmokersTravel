package app.user;

import app.user.model.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface LogsRepository extends JpaRepository<Logs, Integer> {
    @Transactional
    @Modifying
    @Query("update Logs set status = :status")
    void updateLogs(@Param("status") boolean status);
}
