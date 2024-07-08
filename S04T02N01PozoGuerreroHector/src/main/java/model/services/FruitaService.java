package model.services;

import model.domain.*;;
import model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface FruitaService {

    Fruita addFruita(Fruita fruita);

    Fruita updateFruita(Fruita fruita);

    void deleteFruita(int id);

    Optional<Fruita> getFruita(int id);

    List<Fruita> getAllFruita();
}
