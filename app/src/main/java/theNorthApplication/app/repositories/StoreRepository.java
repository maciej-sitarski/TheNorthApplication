package theNorthApplication.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import theNorthApplication.app.entity.Store;

import javax.persistence.criteria.CriteriaBuilder;

public interface StoreRepository extends JpaRepository<Store, Integer> {

    Store findById(String id);
}
