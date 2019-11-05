package app.route;

import app.route.model.AvailableRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableRouteRepository extends JpaRepository<AvailableRoute, Integer> {
}
