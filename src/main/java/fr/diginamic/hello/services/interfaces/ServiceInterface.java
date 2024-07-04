package fr.diginamic.hello.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T, DTO> {
    /** Permets de sauvegarder une nouvelle donnée */
    public List<T> save(DTO toAdd);

    /** Permets de mettre à jour une donnée */
    public List<T> update(T toUpdate);

    /** Permets de supprimer une donnée */
    public List<T> delete(Integer toDelete);

    /** Permets de lister toutes les donnée */
    public List<T> findAll();

    /** Permets de trouver une donnée par son identifiant */
    public T findById(Integer id);

    /** Permets de trouver une donnée par son titre */
    public T findByTitle(String title);

    /** Permets de compter le nombre de donnée enregistrées */
    public Long count();
}
