package academy.ennate.service;

import academy.ennate.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();

    //List<Vehicle> findAll(String id);

    List<Vehicle> create(List<Vehicle> vehicle);

    //Vehicle update(String vin, Vehicle vehicle);

}
