package com.yash.teacoffeevemdingmachine.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.teacoffeevemdingmachine.dao.OrderDAO;
import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.enumeration.Drink;
import com.yash.teacoffeevemdingmachine.exception.EmptyListException;
import com.yash.teacoffeevemdingmachine.exception.NullObjectException;
import com.yash.teacoffeevemdingmachine.util.JsonUtil;

public class OrderDAOImpl implements OrderDAO {

	private Logger logger = Logger.getLogger(ContainerDAOImpl.class);
	
	@Override
	public List<Order> getOrders() {
		logger.info("Getting list of orders:");
		List<Order> orderList = JsonUtil.readOrderJSONFromFile();
		if(orderList.isEmpty()) {
			throw new EmptyListException("Order List is empty");
		}
		return orderList;
	}

	@Override
	public int saveOrder(Order order) {
		int rowsAffected = 0;
		if(order == null) {
			throw new NullObjectException("Order cannot be null");
		}
		
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		
		JsonUtil.writeJSONToFile(orders);
		rowsAffected = 1;
		return rowsAffected;
	}

	@Override
	public List<Order> getOrdersByDrink(Drink drink) {
		List<Order> selectedOrders = new ArrayList<>();
		List<Order> orders = getOrders();
		if(orders.isEmpty()) {
			throw new EmptyListException("Order List is empty");
		}
		if(orders.size()>0 || orders != null) {
			for (Order order : orders) {
				if(order.getDrink() == drink) {
					selectedOrders.add(order);
				}
			}
		}
		return selectedOrders;
	}
	

}
