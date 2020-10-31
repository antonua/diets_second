package net.dietsHelper.Diets.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dietsHelper.Diets.models.Ingredient;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DietForm {
    private String title;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean diaryFree;
    private boolean veryHealthy;
    private List<Ingredient> ingredients;
    private int timeOfCooking;
    private int servings;
    private String imgURL;
    private String summary;
    private String instructions;
    private String spoonacularSourceUrl;
    private List<String> dishTypes;


}
