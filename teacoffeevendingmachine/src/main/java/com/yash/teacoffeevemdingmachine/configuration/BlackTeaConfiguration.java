package com.yash.teacoffeevemdingmachine.configuration;

import java.util.HashMap;
import java.util.Map;

import com.yash.teacoffeevemdingmachine.enumeration.Drink;
import com.yash.teacoffeevemdingmachine.enumeration.Ingredient;

public class BlackTeaConfiguration extends AbstractDrinkConfiguration {
	
	private static IDrinkConfiguration drinkConfigurer;
	public static final double TEA_CONSUMPTION = 3;
	public static final double WATER_CONSUMPTION = 100;
	public static final double SUGAR_CONSUMPTION = 15;
	
	public static final double TEA_WASTAGE = 0;
	public static final double WATER_WASTAGE = 12;
	public static final double SUGAR_WASTAGE = 2;
	
	public static final double RATE = 15;
	
	static{
		drinkConfigurer = new BlackTeaConfiguration();
	}
	
	public static IDrinkConfiguration getDrinkconfiguration() {
		return drinkConfigurer;
	}

	@Override
	public void configIngredientConsumption() {
		Map<Ingredient, Double> ingredientConsumption = new HashMap<>();
		ingredientConsumption.put(Ingredient.TEA, TEA_CONSUMPTION);
		ingredientConsumption.put(Ingredient.WATER, WATER_CONSUMPTION);
		ingredientConsumption.put(Ingredient.SUGAR, SUGAR_CONSUMPTION);
		setIngredientConsumption(ingredientConsumption);
	}

	@Override
	public void configIngredientWastage() {
		Map<Ingredient, Double> ingredientWastage = new HashMap<>();
		ingredientWastage.put(Ingredient.TEA, TEA_WASTAGE);
		ingredientWastage.put(Ingredient.WATER, WATER_WASTAGE);
		ingredientWastage.put(Ingredient.SUGAR, SUGAR_WASTAGE);
		setIngredientWastage(ingredientWastage);
	}

	@Override
	public void configDrinkType() {
		setDrinkType(Drink.BLACK_TEA);
	}

	@Override
	public void configDrinkRate() {
		setDrinkRate(RATE);
	}

}
