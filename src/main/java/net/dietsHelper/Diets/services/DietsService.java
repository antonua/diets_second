package net.dietsHelper.Diets.services;

import net.dietsHelper.Diets.models.Diet;

import java.util.Optional;

public interface DietsService {


    Optional<Diet> findRandomRecipe(String typeName);
    StringBuffer findByName(String dietName);

}
