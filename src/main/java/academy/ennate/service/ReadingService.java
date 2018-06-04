package academy.ennate.service;

import academy.ennate.entity.Reading;
import academy.ennate.entity.Tires;

import java.util.List;

public interface ReadingService {

    List<Reading> findAll();

    Reading create(Reading readings);


}
