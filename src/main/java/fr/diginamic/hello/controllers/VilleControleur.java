package fr.diginamic.hello.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.hello.models.Ville;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
    List<Ville> villes = new ArrayList<>(
            Arrays.asList(new Ville("Paris", 1000000), new Ville("Lyon", 500000), new Ville("Marseille", 50000)));

    @GetMapping
    public ResponseEntity<List<Ville>> All() {
        return ResponseEntity.ok(villes);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Ville ville) {
        Optional<Ville> occ = villes.stream().filter(v -> v.getNom().equals(ville.getNom())).findFirst();

        if (occ.isPresent()) {
            return ResponseEntity.badRequest().body("La ville existe déjà");
        } else {
            villes.add(ville);
            return ResponseEntity.ok("Ville ajoutee");
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Ville ville) {
        Optional<Ville> occ = villes.stream().filter(v -> v.getNom().equals(ville.getNom())).findFirst();

        if (occ.isPresent()) {
            villes.get(villes.indexOf(occ.get())).setNbHabitants(ville.getNbHabitants());
            return ResponseEntity.ok("Ville modifiée");
        } else {
            return ResponseEntity.badRequest().body("La ville n'existe pas");
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam String ville) {
        System.out.println(ville);
        Optional<Ville> occ = villes.stream().filter(v -> v.getNom().equals(ville)).findFirst();
        if (occ.isPresent()) {
            villes.remove(occ.get());
            return ResponseEntity.ok("Ville supprimée");
        } else {
            return ResponseEntity.badRequest().body("La ville n'existe pas");
        }
    }
}
