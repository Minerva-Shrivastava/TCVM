package com.yash.teacoffeevemdingmachine.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.teacoffeevemdingmachine.dao.ContainerDAO;
import com.yash.teacoffeevemdingmachine.domain.Container;
import com.yash.teacoffeevemdingmachine.enumeration.Ingredient;
import com.yash.teacoffeevemdingmachine.exception.ContainerNotFoundException;
import com.yash.teacoffeevemdingmachine.exception.NullObjectException;
import com.yash.teacoffeevemdingmachine.util.JsonUtil;

public class ContainerDAOImpl implements ContainerDAO {

	private List<Container> containers;
	private static ContainerDAOImpl containerDAOImpl = new ContainerDAOImpl();
	private JsonUtil jsonUtil = new JsonUtil();
	private Logger logger = Logger.getLogger(ContainerDAOImpl.class);

	public ContainerDAOImpl() {
		containers = new ArrayList<Container>();
		containers.add(new Container(Ingredient.COFFEE, 2000, 2000));
		containers.add(new Container(Ingredient.MILK, 10000, 10000));
		containers.add(new Container(Ingredient.SUGAR, 8000, 8000));
		containers.add(new Container(Ingredient.TEA, 2000, 2000));
		containers.add(new Container(Ingredient.WATER, 15000, 15000));
		saveContainers(containers);
	}

	private void saveContainers(List<Container> containers) {
		//logger.info("Saving containers");
		jsonUtil.writeObjectToJson(containers);

	}

	public static ContainerDAOImpl getInstance() {
		return containerDAOImpl;
	}

	@Override
	public Container getContainerByIngredient(Ingredient ingredient) {
		if (ingredient == null) {
			throw new NullObjectException("Ingredient Field can not be null");
		}
		List<Container> containers = getAllContainers();
		for (Container container : containers) {
			if(container.getIngredient().equals(ingredient))
				return container;
		}
		throw new ContainerNotFoundException("There is no container of this ingredient");
	}

	@Override
	public Container updateContainer(Container givenContainer) {
		if (givenContainer.getIngredient() == null && givenContainer == null) {
			throw new NullObjectException("Ingredient And Container values cannot null");
		}

		for (Container container : containers) {
			if (container.getIngredient() == givenContainer.getIngredient()) {
				containers.set(containers.indexOf(container), givenContainer);
				break;
			}
		}

		saveContainers(containers);
		return givenContainer;

	}

	@Override
	public List<Container> getAllContainers() {
		containers = jsonUtil.readObjectFromJson();
		return containers;
	}

	@Override
	public boolean refillAllContainers() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean refillContainer(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return false;
	}

}
