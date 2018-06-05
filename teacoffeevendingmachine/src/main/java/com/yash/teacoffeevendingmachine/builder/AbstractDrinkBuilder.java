package com.yash.teacoffeevendingmachine.builder;

import java.util.Map;

import org.apache.log4j.Logger;

import com.yash.teacoffeevemdingmachine.configuration.AbstractDrinkConfiguration;
import com.yash.teacoffeevemdingmachine.configuration.IDrinkConfiguration;
import com.yash.teacoffeevemdingmachine.domain.Container;
import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.enumeration.Ingredient;
import com.yash.teacoffeevemdingmachine.exception.ContainerUnderFlowException;
import com.yash.teacoffeevemdingmachine.service.ContainerService;
import com.yash.teacoffeevemdingmachine.serviceimpl.ContainerServiceImpl;
import com.yash.teacoffeevemdingmachine.serviceimpl.OrderServiceImpl;

public class AbstractDrinkBuilder implements IDrinkBuilder {

	private Logger logger = Logger.getLogger(AbstractDrinkBuilder.class);
	
	IDrinkConfiguration drinkConfigurer;
	ContainerService containerService = new ContainerServiceImpl();
	
	@Override
	public void setDrinkConfiguration(IDrinkConfiguration drinkConfigurer) {
		this.drinkConfigurer = drinkConfigurer;
	}

	@Override
	public void prepareDrink(Order order) {
		logger.info("Preparing your drink...");
		AbstractDrinkConfiguration abstractDrinkConfiguration = (AbstractDrinkConfiguration) drinkConfigurer;
		
		Map<Ingredient, Double> consumption = abstractDrinkConfiguration.getIngredientConsumption();
		Map<Ingredient, Double> wastage = abstractDrinkConfiguration.getIngredientWastage();
		
		for (Map.Entry<Ingredient, Double> entry : consumption.entrySet()) {
			Container container = containerService.getContainerByIngredient(entry.getKey());
			double quantityWasted = wastage.get(entry.getKey());
			double quantityConsumed = entry.getValue();
			double quantityAvailable = container.getCurrentAvailability();
			int noOfCups = order.getQuantity();
			
			if ((noOfCups * (quantityConsumed + quantityWasted)) > quantityAvailable) {
				order.setStatus(false);
				throw new ContainerUnderFlowException(entry.getKey() + " insufficient");
			}
			container.setCurrentAvailability(quantityAvailable - (noOfCups * (quantityConsumed + quantityWasted)));
			order.setTotalAmount(abstractDrinkConfiguration.getDrinkRate() * noOfCups);
			
			System.out.println("Ingredient :" + container.getIngredient() + " Max capacity: "
					+ container.getMaxCapacity() + " Current availability: " + container.getCurrentAvailability());
			containerService.updateContainer(entry.getKey(), container);

		}
		order.setStatus(true);
		logger.info("order is ready");
		System.out.println("Order :"+order);
		
	}

}
