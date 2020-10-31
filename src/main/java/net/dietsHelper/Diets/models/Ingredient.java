package net.dietsHelper.Diets.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingredient {

    private int id;

    private String originalName;

    private double amount;

    private String original;

}
