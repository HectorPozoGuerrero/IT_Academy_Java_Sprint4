package model.services;

import model.domain.*;;
import model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaService {

    @Autowired
    private FruitaRepository fruitaRepository;

    public Fruita addFruita(Fruita fruita) {
        return fruitaRepository.save(fruita);
    }

    public Fruita updateFruita(Fruita fruita) {
        return fruitaRepository.save(fruita);
    }

    public void deleteFruita(int id) {
        fruitaRepository.deleteById(id);
    }

    public Optional<Fruita> getFruita(int id) {
        return fruitaRepository.findById(id);
    }

    public List<Fruita> getAllFruita() {
        return fruitaRepository.findAll();
    }
}
