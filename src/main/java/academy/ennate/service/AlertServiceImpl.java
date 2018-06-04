package academy.ennate.service;

import academy.ennate.entity.Alert;
import academy.ennate.exception.ResourceNotFoundException;
import academy.ennate.repository.AlertRepository;
import academy.ennate.repository.ReadingRepository;
import academy.ennate.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private ReadingRepository readingRepository;

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Alert> findAll() {
        return (List<Alert>) alertRepository.findAll();
    }

    @Override
    @Transactional
    public Alert create(Alert alert) {
            return alertRepository.save(alert);
        }

    @Transactional
    public List<Alert> findByReadings_vin(String readings_vin) {
        List<Alert> alert = alertRepository.findByReadings_vin(readings_vin);
//        if(!alert.isPresent())      {
//            throw new ResourceNotFoundException("Vehicle with id= "+readings_vin+" not found");
//        }
        return alert;
    }

    /*
    @Transactional
    public List<Alert> findbyPriorityAndReadings_timestamp(String PriorityAndReadings_timestamp) {
//        String priority="HIGH";
//        Timestamp readings_timestamp = new Timestamp(System.currentTimeMillis()+120*60*1000);
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        TypedQuery<Alert> query =  entityManager.createNamedQuery("Alert.findbyPriorityAndReadings_timestamp", Alert.class);
//        query.setParameter("paramPriority",priority);
//        query.setParameter("paramTimestamp",readings_timestamp);
//        List<Alert> resultlist = query.getResultList();
//
        List<Alert> alert = alertRepository.findByPriorityAndReadings_timestamp(PriorityAndReadings_timestamp);
        return alert;
    }
*/
}
