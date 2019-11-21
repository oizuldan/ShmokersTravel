package app.session;

import app.session.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer>{

    @Query("select userId from Session where hash = :hash")
    int getUserId(@Param("hash") String hash);

    @Transactional
    @Modifying
    @Query("delete from Session where hash = :hash")
    void deleteSession(@Param("hash") String hash);

}
