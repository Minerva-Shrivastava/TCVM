package com.yash.teacoffeevemdingmachine.serviceimpl;

import java.util.List;

import com.yash.teacoffeevemdingmachine.dao.ContainerDAO;
import com.yash.teacoffeevemdingmachine.daoimpl.ContainerDAOImpl;
import com.yash.teacoffeevemdingmachine.domain.Container;
import com.yash.teacoffeevemdingmachine.enumeration.Ingredient;
import com.yash.teacoffeevemdingmachine.exception.NullObjectException;
import com.yash.teacoffeevemdingmachine.service.ContainerService;

public class ContainerServiceImpl implements ContainerService {

	private List<Container> containers;
	private static ContainerServiceImpl containerServiceImpl = new ContainerServiceImpl();
	private ContainerDAO containerDAO;

	public ContainerServiceImpl() {
	}

	public ContainerServiceImpl(ContainerDAO containerDAO) {
		this.containerDAO = containerDAO;
	}

	public static ContainerServiceImpl getInstance() {
		return containerServiceImpl;
	}

	@Override
	public Container getContainerByIngredient(Ingredient ingredient) {
		containerDAO = ContainerDAOImpl.getInstance();
		return containerDAO.getContainerByIngredient(ingredient);
	}

	@Override
	public List<Container> getContainers() {
		return containers;
	}

	@Override
	public Container updateContainer(Ingredient ingredient, Container container) {
		if (ingredient == null && container == null) {
			throw new NullObjectException("Ingredient And Container values cannot null");
		}
		Container updatedContainer = containerDAO.updateContainer(container);
		return updatedContainer;
	}

	@Override
	public Integer refillContainers() {
		containers = containerDAO.getAllContainers();
		double diff;
		int rowsAffected = 0;
		for (Container container : containers) {
			diff = container.getMaxCapacity() - container.getCurrentAvailability();
			System.out.println(container.getIngredient() + " : Difference " + diff + " , Available : "
					+ container.getCurrentAvailability() + " , Max Capacity : " + container.getMaxCapacity());
			container.setCurrentAvailability(container.getCurrentAvailability() + diff);
			updateContainer(container.getIngredient(), container);
		}
		rowsAffected = containers.size();
		return rowsAffected;
	}

	@Override
	public Integer containerStatus() {
		containers = containerDAO.getAllContainers();
		int rowsAffected = 0;
		
		for (Container container : containers) {
			System.out.println(
					"Ingredient : " + container.getIngredient() + " , Max capacity: " + container.getMaxCapacity()
							+ " , Current availability: " + container.getCurrentAvailability() + "");
		}
		rowsAffected = containers.size();
		System.out.println("Container Refilled Successfully");
		return rowsAffected;
	}

	@Override
	public void resetContainers() {
		// TODO Auto-generated method stub
		
	}

}
