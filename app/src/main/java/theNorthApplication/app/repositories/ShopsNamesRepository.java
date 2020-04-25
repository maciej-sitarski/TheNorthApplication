package theNorthApplication.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import theNorthApplication.app.entity.ShopsNames;

public interface ShopsNamesRepository extends JpaRepository<ShopsNames, Integer> {
}
