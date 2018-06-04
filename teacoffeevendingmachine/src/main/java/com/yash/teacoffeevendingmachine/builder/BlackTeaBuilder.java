package com.yash.teacoffeevendingmachine.builder;

import com.yash.teacoffeevemdingmachine.configuration.BlackTeaConfiguration;
import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.enumeration.Drink;

public class BlackTeaBuilder extends AbstractDrinkBuilder {
	
	public BlackTeaBuilder() {
		setDrinkConfiguration(BlackTeaConfiguration.getDrinkconfiguration());
	}
	
	@Override
	public void prepareDrink(Order order) {
		if(order.getDrink() == Drink.BLACK_TEA) {
			super.prepareDrink(order);
		}else {
			throw new IllegalArgumentException("Wrong Drink type, required "+Drink.BLACK_TEA);
		}
	}
	
	public static IDrinkBuilder getDrinkBuilder() {
		return new BlackTeaBuilder();
	}
	

}
