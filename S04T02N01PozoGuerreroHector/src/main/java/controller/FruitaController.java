package controllers;

import model.domain.Fruita;
import model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    private FruitaService fruitaService;

    @PostMapping("/add")
    public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita) {
        Fruita newFruita = fruitaService.addFruita(fruita);
        return ResponseEntity.ok(newFruita);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruita> updateFruita(@RequestBody Fruita fruita) {
        Fruita updatedFruita = fruitaService.updateFruita(fruita);
        return ResponseEntity.ok(updatedFruita);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruita(@PathVariable int id) {
        fruitaService.deleteFruita(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getFruita(@PathVariable int id) {
        Optional<Fruita> fruita = fruitaService.getFruita(id);
        return fruita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruita() {
        List<Fruita> fruites = fruitaService.getAllFruita();
        return ResponseEntity.ok(fruites);
    }
}
