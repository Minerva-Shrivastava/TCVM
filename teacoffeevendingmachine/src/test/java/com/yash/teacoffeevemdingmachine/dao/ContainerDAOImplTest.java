package com.yash.teacoffeevemdingmachine.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yash.teacoffeevemdingmachine.dao.ContainerDAO;
import com.yash.teacoffeevemdingmachine.daoimpl.ContainerDAOImpl;
import com.yash.teacoffeevemdingmachine.domain.Container;
import com.yash.teacoffeevemdingmachine.enumeration.Ingredient;
import com.yash.teacoffeevemdingmachine.exception.NullObjectException;

public class ContainerDAOImplTest {

	private ContainerDAO containerDAO;

	@Before
	public void init() {
		containerDAO = ContainerDAOImpl.getInstance();
	}

	@Test(expected = NullObjectException.class)
	public void getContainerByIngredient_IngredientNotGiven_ShouldThrowNullFieldException() {
		Ingredient ingredient = null;
		containerDAO.getContainerByIngredient(ingredient);
	}
	
	@Test
	public void getContainerByIngredient_IngredientGiven_ShouldReturnContainer() {
		Ingredient ingredient = Ingredient.COFFEE;
		Container container = containerDAO.getContainerByIngredient(ingredient);
		assertEquals(ingredient, container.getIngredient());
	}

	/*@Test(expected = NullObjectException.class)
	public void updateContainer_IngredientIsNullAndContainerIsNullGiven_ShouldThrowNullObjectException() {
		Ingredient ingredient = null;
		Container container = null;
		containerDAO.updateContainer(ingredient, container);
	}

	@Test
	public void updateContainer_ContainerGiven_ShouldReturnTrueWhenContainerIsUpdated() throws Exception {
		Container container = new Container(Ingredient.COFFEE, 2000, 200);
		boolean containerUpdated = containerDAO.updateContainer(container);
		assertTrue(containerUpdated);
	}

	@Test
	public void getListOfContainers_ShouldReturnListOfContainers() {
		List<Container> containers = containerDAO.getListOfContainers();
		int sizeOfContainers = containers.size();
		assertEquals(5, sizeOfContainers);
	}*/

}
