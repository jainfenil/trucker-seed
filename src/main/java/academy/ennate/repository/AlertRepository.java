package academy.ennate.repository;

import academy.ennate.entity.Alert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlertRepository extends CrudRepository<Alert, String> {
    List<Alert> findByReadings_vin(String readings_vin);
  //
    //  List<Alert> findByPriorityAndReadings_timestamp(String PriorityAndReadings_timestamp);
}
