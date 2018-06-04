package academy.ennate.controller;

import academy.ennate.entity.Reading;
import academy.ennate.entity.Tires;
import academy.ennate.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    public ReadingService readingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reading> findAll(){
        return readingService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Reading create(@RequestBody Reading reading){
        return readingService.create(reading);
    }

}
