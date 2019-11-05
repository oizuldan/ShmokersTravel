package app.session;

import app.session.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer>{

//    List<Session> findByHash(int hash);

}
