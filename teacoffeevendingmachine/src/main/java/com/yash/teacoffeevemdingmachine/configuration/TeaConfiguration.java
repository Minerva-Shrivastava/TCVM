package com.yash.teacoffeevemdingmachine.configuration;

import java.util.HashMap;
import java.util.Map;

import com.yash.teacoffeevemdingmachine.enumeration.Drink;
import com.yash.teacoffeevemdingmachine.enumeration.Ingredient;

public class TeaConfiguration extends AbstractDrinkConfiguration {
	private static IDrinkConfiguration drinkConfigurer;

	public static final double WATER_CONSUMPTION = 60;
	public static final double SUGAR_CONSUMPTION = 15;
	public static final double MILK_CONSUMPTION = 40;
	public static final double TEA_CONSUMPTION = 5;

	public static final double WATER_WASTAGE = 5;
	public static final double SUGAR_WASTAGE = 2;
	public static final double MILK_WASTAGE = 4;
	public static final double TEA_WASTAGE = 1;

	public static final double RATE = 10;
	
	static {
		drinkConfigurer = new TeaConfiguration();
	}

	public static IDrinkConfiguration getDrinkConfigurer() {
		return drinkConfigurer;
	}

	@Override
	public void configIngredientConsumption() {
		Map<Ingredient, Double> ingredientConsumption = new HashMap<>();
		ingredientConsumption.put(Ingredient.TEA, TEA_CONSUMPTION);
		ingredientConsumption.put(Ingredient.MILK, MILK_CONSUMPTION);
		ingredientConsumption.put(Ingredient.SUGAR, SUGAR_CONSUMPTION);
		ingredientConsumption.put(Ingredient.WATER, WATER_CONSUMPTION);
		setIngredientConsumption(ingredientConsumption);
		
	}

	@Override
	public void configIngredientWastage() {
		Map<Ingredient, Double> ingredientWastage = new HashMap<>();
		ingredientWastage.put(Ingredient.TEA, TEA_WASTAGE);
		ingredientWastage.put(Ingredient.MILK, MILK_WASTAGE);
		ingredientWastage.put(Ingredient.SUGAR, SUGAR_WASTAGE);
		ingredientWastage.put(Ingredient.WATER, WATER_WASTAGE);
		setIngredientWastage(ingredientWastage);
		
	}

	@Override
	public void configDrinkType() {
		setDrinkType(Drink.TEA);
		
	}

	@Override
	public void configDrinkRate() {
		setDrinkRate(RATE);
	}


	
	

}
