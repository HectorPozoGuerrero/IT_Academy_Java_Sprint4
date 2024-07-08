package model.services.impl;

import exceptions.FruitNotFoundException;
import model.domain.Fruita;
import model.repository.FruitaRepository;
import model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaServiceImpl implements FruitaService {
    @Autowired
    private FruitaRepository fruitaRepository;

    @Override
    public Fruita addFruita(Fruita fruit) {
        return fruitaRepository.save(fruit);
    }

    @Override
    public Fruita updateFruita(Fruita fruit) {
        if (!fruitaRepository.existsById(fruit.getId())) {
            throw new FruitNotFoundException("No fruit found with id: " + (fruit.getId()));
        }
        return fruitaRepository.save(fruit);
    }

    @Override
    public void deleteFruita(int id) {
        if (fruitaRepository.existsById(id)) {
            fruitaRepository.deleteById(id);
        } else {
            throw new FruitNotFoundException("No fruit found with id: " + id);
        }
    }

    @Override
    public Optional<Fruita> getFruita(int id) {
        return Optional.ofNullable(fruitaRepository.findById(id).orElseThrow(() -> new FruitNotFoundException("No fruit found with id: " + id)));
    }

    @Override
    public List<Fruita> getAllFruita() {
        return fruitaRepository.findAll();
    }
}
