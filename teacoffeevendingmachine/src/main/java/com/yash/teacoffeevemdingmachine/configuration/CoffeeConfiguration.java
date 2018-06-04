package com.yash.teacoffeevemdingmachine.configuration;

import java.util.HashMap;
import java.util.Map;

import com.yash.teacoffeevemdingmachine.enumeration.Drink;
import com.yash.teacoffeevemdingmachine.enumeration.Ingredient;

public class CoffeeConfiguration extends AbstractDrinkConfiguration {
	
	private static IDrinkConfiguration drinkConfigurer;
	public static final double COFFEE_CONSUMPTION = 4;
	public static final double WATER_CONSUMPTION = 20;
	public static final double MILK_CONSUMPTION = 80;
	public static final double SUGAR_CONSUMPTION = 15;
	
	public static final double COFFEE_WASTAGE = 1;
	public static final double WATER_WASTAGE = 3;
	public static final double MILK_WASTAGE = 8;
	public static final double SUGAR_WASTAGE = 2;
	
	public static final double RATE = 15;
	
	static {
		drinkConfigurer = new CoffeeConfiguration();
	}
	
	public static IDrinkConfiguration getDrinkConfiguration() {
		return drinkConfigurer;
	}

	@Override
	public void configIngredientConsumption() {
		Map<Ingredient, Double> ingredientConsumption = new HashMap<>();
		ingredientConsumption.put(Ingredient.COFFEE, COFFEE_CONSUMPTION);
		ingredientConsumption.put(Ingredient.WATER, WATER_CONSUMPTION);
		ingredientConsumption.put(Ingredient.MILK, MILK_CONSUMPTION);
		ingredientConsumption.put(Ingredient.SUGAR, SUGAR_CONSUMPTION);
		setIngredientConsumption(ingredientConsumption);
	}

	@Override
	public void configIngredientWastage() {
		Map<Ingredient, Double> ingredientWastage = new HashMap<>();
		ingredientWastage.put(Ingredient.COFFEE, COFFEE_WASTAGE);
		ingredientWastage.put(Ingredient.WATER, WATER_WASTAGE);
		ingredientWastage.put(Ingredient.MILK, MILK_WASTAGE);
		ingredientWastage.put(Ingredient.SUGAR, SUGAR_WASTAGE);
		setIngredientWastage(ingredientWastage);
	}

	@Override
	public void configDrinkType() {
		setDrinkType(Drink.COFFEE);
	}

	@Override
	public void configDrinkRate() {
		setDrinkRate(RATE);
		
	}
	
	
	

}
