package com.yash.teacoffeevendingmachine.builder;

import org.apache.log4j.Logger;

import com.yash.teacoffeevemdingmachine.configuration.TeaConfiguration;
import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.enumeration.Drink;

public class TeaBuilder extends AbstractDrinkBuilder {

	Logger logger = Logger.getLogger(TeaBuilder.class);
	
	public TeaBuilder() {
		setDrinkConfiguration(TeaConfiguration.getDrinkConfigurer());
	}

	@Override
	public void prepareDrink(Order order) {
		
		if (order.getDrink() == Drink.TEA) {
			super.prepareDrink(order);
		} else {
			throw new IllegalArgumentException("Wrong Drink Type, required " + Drink.TEA);
		}
	}

	public static IDrinkBuilder getDrinkBuilder() {
		return new TeaBuilder();
	}

}
