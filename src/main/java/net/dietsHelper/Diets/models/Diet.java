package net.dietsHelper.Diets.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Diet {

    private String title;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean diaryFree;
    private boolean veryHealthy;
    private List<Ingredient> extendedIngredients;
    private int readyInMinutes;
    private int servings;
    private String image;
    private String summary;
    private String instructions;
    private String sourceUrl;
    private List<String> dishTypes;
    private List<String> diets;
}
