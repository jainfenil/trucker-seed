package academy.ennate.repository;

import academy.ennate.entity.Tires;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TireRepository extends CrudRepository<Tires, String> {
}
