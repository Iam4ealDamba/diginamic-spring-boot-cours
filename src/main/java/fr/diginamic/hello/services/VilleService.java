package fr.diginamic.hello.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.hello.dto.VilleDto;
import fr.diginamic.hello.models.Ville;
import fr.diginamic.hello.repositories.VilleRepository;
import fr.diginamic.hello.services.interfaces.ServiceInterface;

@Service
public class VilleService implements ServiceInterface<Ville, VilleDto> {

    @Autowired
    VilleRepository villeRepository;

    @Override
    public List<Ville> save(VilleDto toAdd) {
        Optional<Ville> occ = villeRepository.findAll().stream().filter(v -> v.getNom().equals(toAdd.getNom()))
                .findFirst();
        if (occ.isPresent()) {
            return null;
        } else {
            Ville ville = new Ville();
            ville.setNom(toAdd.getNom());
            ville.setNbHabitants(toAdd.getNbHabitants());

            villeRepository.save(ville);
            return villeRepository.findAll();
        }
    }

    @Override
    public List<Ville> update(Ville toUpdate) {
        Optional<Ville> occ = villeRepository.findAll().stream().filter(v -> v.getId().equals(toUpdate.getId()))
                .findFirst();

        if (occ.isPresent()) {
            villeRepository.save(toUpdate);
            return villeRepository.findAll();
        } else {
            return null;
        }
    }

    @Override
    public List<Ville> delete(Integer toDelete) {
        Optional<Ville> occ = villeRepository.findAll().stream().filter(v -> v.getId().equals(toDelete))
                .findFirst();

        if (occ.isPresent()) {
            villeRepository.delete(occ.get());
            return villeRepository.findAll();
        } else {
            return null;
        }
    }

    @Override
    public List<Ville> findAll() {
        return villeRepository.findAll();
    }

    @Override
    public Ville findById(Integer id) {
        Optional<Ville> occ = villeRepository.findAll().stream().filter(v -> v.getId().equals(id))
                .findFirst();

        if (occ.isPresent()) {
            return occ.get();
        } else {
            return null;
        }
    }

    @Override
    public Ville findByTitle(String title) {
        Optional<Ville> occ = villeRepository.findAll().stream().filter(v -> v.getNom().equals(title)).findFirst();

        if (occ.isPresent()) {
            return occ.get();
        } else {
            return null;
        }
    }

    @Override
    public Long count() {
        return villeRepository.count();
    }

}
