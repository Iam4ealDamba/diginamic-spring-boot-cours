package fr.diginamic.hello.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.hello.dto.VilleDto;
import fr.diginamic.hello.models.Ville;
import fr.diginamic.hello.services.VilleService;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
    @Autowired
    VilleService villeService;

    @GetMapping
    public ResponseEntity<List<Ville>> All() {
        Optional<List<Ville>> villes = Optional.ofNullable(villeService.findAll());

        if (villes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(villes.get());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Ville> OneById(@PathVariable Integer id) {
        Optional<Ville> villes = Optional.ofNullable(villeService.findById(id));

        if (villes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(villes.get());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Ville> OneByTitle(@PathVariable String nom) {
        Optional<Ville> villes = Optional.ofNullable(villeService.findByTitle(nom));

        if (villes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(villes.get());
    }

    @PostMapping
    public ResponseEntity<List<Ville>> save(@RequestBody VilleDto ville) {
        Optional<List<Ville>> villes = Optional.ofNullable(villeService.save(ville));

        if (villes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(villes.get());
        }
    }

    @PutMapping
    public ResponseEntity<List<Ville>> update(@RequestBody Ville ville) {
        Optional<List<Ville>> villes = Optional.ofNullable(villeService.update(ville));

        if (villes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(villes.get());
        }
    }

    @DeleteMapping
    public ResponseEntity<List<Ville>> delete(@RequestParam Integer id) {
        Optional<List<Ville>> villes = Optional.ofNullable(villeService.delete(id));

        if (villes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(villes.get());
        }
    }
}
