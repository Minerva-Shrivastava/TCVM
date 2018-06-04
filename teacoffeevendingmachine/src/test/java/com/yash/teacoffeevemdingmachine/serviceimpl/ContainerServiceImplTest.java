package com.yash.teacoffeevemdingmachine.serviceimpl;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yash.teacoffeevemdingmachine.dao.ContainerDAO;
import com.yash.teacoffeevemdingmachine.domain.Container;
import com.yash.teacoffeevemdingmachine.enumeration.Ingredient;
import com.yash.teacoffeevemdingmachine.exception.NullObjectException;
import com.yash.teacoffeevemdingmachine.service.ContainerService;
import com.yash.teacoffeevemdingmachine.serviceimpl.ContainerServiceImpl;

public class ContainerServiceImplTest {

	ContainerService containerService;

	ContainerDAO containerDAO = mock(ContainerDAO.class);

	@Before
	public void init() {
		containerService = new ContainerServiceImpl(containerDAO);
	}

	@Test(expected = NullObjectException.class)
	public void getContainerByIngredient_IngredientIsNullGiven_ShouldReturnNullObjectException() {
		Ingredient ingredient = null;
		containerService.getContainerByIngredient(ingredient);
	}

	@Test
	public void getContainerByIngredient_IngredientIsGiven_ShouldReturnContainerOfSpecifiedIngredient() {
		Ingredient ingredient = Ingredient.COFFEE;
		Container container = new Container(ingredient, 2000.00, 2000.00);
		List<Container> containers = Arrays.asList(new Container(Ingredient.COFFEE, 2000, 2000),
				new Container(Ingredient.MILK, 10000, 10000), new Container(Ingredient.TEA, 2000, 2000),
				new Container(Ingredient.WATER, 15000, 15000), new Container(Ingredient.SUGAR, 8000, 8000));
		when(containerDAO.getListOfContainers()).thenReturn(containers);
		Container requiredContainer = containerService.getContainerByIngredient(ingredient);
		assertEquals(requiredContainer.getIngredient(), container.getIngredient());
	}

	@Test(expected = NullObjectException.class)
	public void updateContainer_IngredientIsNullAndContainerIsNullGiven_ShouldReturnNullObjectException() {
		Ingredient ingredient = null;
		Container container = null;
		containerService.updateContainer(ingredient, container);
	}

	@Test
	public void updateContainer_IngredientAndContainerGiven_ShouldReturnNullObjectException() {
		Ingredient ingredient = Ingredient.COFFEE;
		Container container = new Container(ingredient, 2000.00, 1900.00);
		Container updateContainer = new Container(ingredient, 2000.00, 1900.00);
		when(containerDAO.updateContainer(ingredient, container)).thenReturn(updateContainer);
		Container returnedContainer = containerService.updateContainer(ingredient, container);
		assertEquals(returnedContainer.getCurrentAvailability(), container.getCurrentAvailability(), 0.00);
	}

	@Test
	public void refillContainers_ShouldReturnSizeOfContainersList() {
		List<Container> containers = Arrays.asList(new Container(Ingredient.COFFEE, 2000, 2000),
				new Container(Ingredient.MILK, 10000, 10000), new Container(Ingredient.TEA, 2000, 2000),
				new Container(Ingredient.WATER, 15000, 15000), new Container(Ingredient.SUGAR, 8000, 8000));
		when(containerDAO.getListOfContainers()).thenReturn(containers);
		int rowsAffected = containerService.refillContainers();
		assertEquals(5, rowsAffected);
	}

	@Test
	public void containerStatus_ShouldReturnSizeOfContainersList() {

		List<Container> containers = Arrays.asList(new Container(Ingredient.COFFEE, 2000, 2000),
				new Container(Ingredient.MILK, 10000, 10000), new Container(Ingredient.TEA, 2000, 2000),
				new Container(Ingredient.WATER, 15000, 15000), new Container(Ingredient.SUGAR, 8000, 8000));
		when(containerDAO.getListOfContainers()).thenReturn(containers);
		int rowsAffected = containerService.containerStatus();
		assertEquals(5, rowsAffected);
	}
}
