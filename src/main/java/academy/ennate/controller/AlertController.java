package academy.ennate.controller;

import academy.ennate.entity.Alert;
import academy.ennate.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alert")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> findAll(){
        return alertService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Alert create(@RequestBody Alert alert){
        return alertService.create(alert);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{readings_vin}")
    public List<Alert> findByReadings_vin(@PathVariable("readings_vin") String readings_vin){
        return alertService.findByReadings_vin(readings_vin);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "{PriorityAndReadings_timestamp}")
//    public List<Alert> findbyPriorityAndReadings_timestamp(@PathVariable("PriorityAndReadings_timestamp") String PriorityAndReadings_timestamp){
//        return alertService.findbyPriorityAndReadings_timestamp(PriorityAndReadings_timestamp);
//    }

}
