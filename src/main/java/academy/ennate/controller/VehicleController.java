package academy.ennate.controller;

import academy.ennate.entity.Vehicle;
import academy.ennate.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

    @Autowired
    public VehicleService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> findAll(){
        return service.findAll();
    }

//    @RequestMapping(method = RequestMethod.GET, value = "{id}")
//    public Vehicle findOne(@PathVariable("id") String id){
//        return service.findOne(id);
//    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicle> create(@RequestBody List<Vehicle> vehicle){
        return service.create(vehicle);
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
//    public Employee update(@PathVariable("id") String id,@RequestBody Employee employee){
//        return service.update(id,employee);
//    }


}
