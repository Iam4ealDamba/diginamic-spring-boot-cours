package fr.diginamic.hello.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VilleDto {
    /** Nom de la ville */
    public String nom;

    /** Nombre d'habitants */
    public Integer nbHabitants;

}
