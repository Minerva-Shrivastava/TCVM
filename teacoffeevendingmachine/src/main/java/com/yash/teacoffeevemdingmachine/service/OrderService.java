package com.yash.teacoffeevemdingmachine.service;

import java.util.List;

import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.enumeration.Drink;

public interface OrderService {
	List<Order> getOrders() ;

	List<Order> getOrdersByDrink(Drink drink);

	int addOrder(Order order);

	void getTotalSales();

}
