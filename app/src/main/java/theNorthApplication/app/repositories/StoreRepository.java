package theNorthApplication.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import theNorthApplication.app.entity.Store;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, String> {

    Optional<Store> findById(String id);
}
