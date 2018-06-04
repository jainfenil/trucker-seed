package academy.ennate.service;

import academy.ennate.entity.Vehicle;
import academy.ennate.exception.ResourceNotFoundException;
import academy.ennate.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return (List<Vehicle>) repository.findAll();
    }

//    @Override
//    public List<Vehicle> findAll(String id) {
//        return null;
//    }

    @Override
    @Transactional
    public List<Vehicle> create(List<Vehicle> vehicle) {
        Iterator<Vehicle> iterator = vehicle.iterator();
        while (iterator.hasNext()) {
            repository.save(iterator.next());
        }
        return vehicle;
    }

    @Transactional
    public Vehicle findOne(String id) {
        Optional<Vehicle> v = repository.findById(id);
        if(!v.isPresent())      {
            throw new ResourceNotFoundException("Vehicle with id= "+id+" not found");
        }
        return v.get();
    }

}
