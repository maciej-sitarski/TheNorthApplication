package theNorthApplication.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import theNorthApplication.app.entity.Locations;

public interface LocationsRepository extends JpaRepository<Locations, Integer> {
}
