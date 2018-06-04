package com.yash.teacoffeevemdingmachine.dao;

import java.util.List;

import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.enumeration.Drink;

public interface OrderDAO {
	List<Order> getOrders();

	int saveOrder(Order order);

	List<Order> getOrdersByDrink(Drink drink);

}
