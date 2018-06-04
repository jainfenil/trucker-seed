package academy.ennate.service;

import academy.ennate.entity.Alert;

import java.util.List;
import java.util.Optional;

public interface AlertService {

    List<Alert> findAll();

    Alert create(Alert alert);

    List<Alert> findByReadings_vin(String readings_vin);

   // List<Alert> findbyPriorityAndReadings_timestamp(String PriorityAndReadings_timestamp);


}
