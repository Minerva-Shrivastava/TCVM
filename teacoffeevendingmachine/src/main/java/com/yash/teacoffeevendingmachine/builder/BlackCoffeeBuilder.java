package com.yash.teacoffeevendingmachine.builder;

import com.yash.teacoffeevemdingmachine.configuration.BlackCoffeeCofiguration;
import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.enumeration.Drink;

public class BlackCoffeeBuilder extends AbstractDrinkBuilder {
	
	public BlackCoffeeBuilder() {
		setDrinkConfiguration(BlackCoffeeCofiguration.getDrinkConfigurer());
	}
	
	@Override
	public void prepareDrink(Order order) {
		if(order.getDrink() == Drink.BLACK_COFFEE) {
			super.prepareDrink(order);
		}else {
			throw new IllegalArgumentException("Wrong drink type, required "+Drink.BLACK_COFFEE);
		}
	}
	
	public static IDrinkBuilder getDrinkBuilder() {
		return new BlackCoffeeBuilder();
	}

}
