package com.yash.teacoffeevendingmachine.builder;

import com.yash.teacoffeevemdingmachine.configuration.CoffeeConfiguration;
import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.enumeration.Drink;

public class CoffeeBuilder extends AbstractDrinkBuilder {
	
	public CoffeeBuilder() {
		setDrinkConfiguration(CoffeeConfiguration.getDrinkConfiguration());
	}
	
	@Override
	public void prepareDrink(Order order) {
		if(order.getDrink() == Drink.COFFEE) {
			super.prepareDrink(order);
		}else {
			throw new IllegalArgumentException("Wrong Drink Type, required "+Drink.COFFEE);
		}
	}
	
	public static IDrinkBuilder getDrinkBuilder() {
		return new CoffeeBuilder();
	}

}
