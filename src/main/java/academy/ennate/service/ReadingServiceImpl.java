package academy.ennate.service;

import academy.ennate.entity.Alert;
import academy.ennate.entity.Reading;
import academy.ennate.entity.Vehicle;
import academy.ennate.repository.AlertRepository;
import academy.ennate.repository.ReadingRepository;
import academy.ennate.repository.TireRepository;
import academy.ennate.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

    @Autowired
    private TireRepository tireRepository;

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Reading> findAll() {
        return (List<Reading>) readingRepository.findAll();
    }

    @Override
    @Transactional
    public Reading create(Reading readings) {

        tireRepository.save(readings.getTires());
        Reading read = readingRepository.save(readings);

        System.out.println("check1");
        Optional<Vehicle> vehicle =  vehicleRepository.findById(readings.getVin());
        System.out.println("veh "+vehicle);
        System.out.println("check2 "+readings.getEngineRpm()+" "+vehicle.get().getRedlineRpm());
        if (readings.getEngineRpm() > vehicle.get().getRedlineRpm()) {
            Alert alert = new Alert();
                alert.setPriority("HIGH");
                alert.setMessage("Engine and ReadLine");
                alert.setReadings(readings);
                alertRepository.save(alert);
            }
        System.out.println("check3");

        if (readings.getFuelVolume() < (0.1 * vehicle.get().getMaxFuelVolume())) {
            Alert alert = new Alert();
            alert.setPriority("MEDIUM");
            alert.setMessage("Alert for fuel");
            alert.setReadings(readings);
            alertRepository.save(alert);
        }
        if (    (readings.getTires().getFrontLeft() < 32) ||
                (readings.getTires().getFrontLeft() > 36) ||
                (readings.getTires().getFrontRight() < 32) ||
                (readings.getTires().getFrontRight() > 36) ||
                (readings.getTires().getRearLeft() < 32) ||
                (readings.getTires().getRearLeft() > 36) ||
                (readings.getTires().getRearRight() < 32) ||
                (readings.getTires().getRearRight() > 36)
                )
        {
                Alert alert = new Alert();
                alert.setPriority("LOW");
                alert.setMessage("Alert for tire pressure");
                alert.setReadings(readings);
                alertRepository.save(alert);
        }


        if (readings.isCheckEngineLightOn() || readings.isEngineCoolantLow()) {
            Alert alert = new Alert();
            alert.setPriority("LOW");
            alert.setMessage("Alert checkEngine and EngineCoolent");
            alert.setReadings(readings);
            alertRepository.save(alert);
        }


        return read;
    }
}
