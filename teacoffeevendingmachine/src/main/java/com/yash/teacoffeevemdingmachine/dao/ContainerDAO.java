package com.yash.teacoffeevemdingmachine.dao;

import java.util.List;

import com.yash.teacoffeevemdingmachine.domain.Container;
import com.yash.teacoffeevemdingmachine.enumeration.Ingredient;

public interface ContainerDAO {
	
	Container getContainerByIngredient(Ingredient ingredient);

	List<Container> getAllContainers();

	Container updateContainer(Container container);

	boolean refillAllContainers();

	boolean refillContainer(Ingredient ingredient);

}
