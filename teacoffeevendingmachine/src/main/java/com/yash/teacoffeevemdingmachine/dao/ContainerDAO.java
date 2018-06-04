package com.yash.teacoffeevemdingmachine.dao;

import java.util.List;

import com.yash.teacoffeevemdingmachine.domain.Container;
import com.yash.teacoffeevemdingmachine.enumeration.Ingredient;

public interface ContainerDAO {
	public Container getContainerByIngredient(Ingredient ingredient);

	public Container updateContainer(Ingredient ingredient, Container container);

	public List<Container> getListOfContainers();

}
