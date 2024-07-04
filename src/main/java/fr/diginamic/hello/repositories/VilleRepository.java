package fr.diginamic.hello.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.hello.models.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {

}
