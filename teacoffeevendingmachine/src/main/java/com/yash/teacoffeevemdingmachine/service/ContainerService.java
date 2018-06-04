package com.yash.teacoffeevemdingmachine.service;

import java.util.List;

import com.yash.teacoffeevemdingmachine.domain.Container;
import com.yash.teacoffeevemdingmachine.enumeration.Ingredient;

public interface ContainerService {

	Container getContainerByIngredient(Ingredient ingredient);

	List<Container> getContainers();

	Container updateContainer(Ingredient ingredient, Container container);

	Integer refillContainers();

	Integer containerStatus();

	void resetContainers();

}
