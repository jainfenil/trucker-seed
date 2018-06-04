package academy.ennate.service;

import academy.ennate.entity.Tires;
import academy.ennate.repository.TireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TiresServiceImpl implements TiresService {

    @Autowired
    private TireRepository repo;

    @Override
    @Transactional
    public Tires create(Tires tires) {
        return repo.save(tires);
    }

}
