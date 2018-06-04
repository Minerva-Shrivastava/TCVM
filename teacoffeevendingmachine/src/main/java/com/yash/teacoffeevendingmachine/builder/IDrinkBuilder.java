package com.yash.teacoffeevendingmachine.builder;

import com.yash.teacoffeevemdingmachine.configuration.IDrinkConfiguration;
import com.yash.teacoffeevemdingmachine.domain.Order;

public interface IDrinkBuilder {

	void setDrinkConfiguration(IDrinkConfiguration drinkConfigurer);

	void prepareDrink(Order order);
	
}
