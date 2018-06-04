package com.yash.teacoffeevemdingmachine.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.yash.teacoffeevemdingmachine.dao.OrderDAO;
import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.enumeration.Drink;
import com.yash.teacoffeevemdingmachine.exception.NullObjectException;
import com.yash.teacoffeevemdingmachine.service.OrderService;
import com.yash.teacoffeevendingmachine.builder.BlackCoffeeBuilder;
import com.yash.teacoffeevendingmachine.builder.BlackTeaBuilder;
import com.yash.teacoffeevendingmachine.builder.CoffeeBuilder;
import com.yash.teacoffeevendingmachine.builder.IDrinkBuilder;
import com.yash.teacoffeevendingmachine.builder.TeaBuilder;

public class OrderServiceImpl implements OrderService {
	
	private OrderDAO orderDAO;
	
	private Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	public OrderServiceImpl(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public List<Order> getOrders() {
		logger.info("Listing the orders");
		List<Order> orders = orderDAO.getOrders();
		if(orders == null) {
			throw new NullObjectException("List of order is null");
		}
		return orders;
	}

	@Override
	public List<Order> getOrdersByDrink(Drink drink) {
		logger.info("getting orders of drink :"+drink);
		List<Order> orderList = orderDAO.getOrdersByDrink(drink);
		
		if(orderList == null) {
			throw new NullObjectException("Order list is null");
		}
		return orderList;
	}

	@Override
	public int addOrder(Order order) {
		IDrinkBuilder drinkBuilder;
		int rowsAffected = 0;
		if(order == null) {
			throw new NullObjectException("Order object is null");
		}
		switch (order.getDrink()) {
		case TEA:
			drinkBuilder = TeaBuilder.getDrinkBuilder();
			drinkBuilder.prepareDrink(order);
			break;
		case COFFEE:
			drinkBuilder = CoffeeBuilder.getDrinkBuilder();
			drinkBuilder.prepareDrink(order);
			break;
		case BLACK_TEA:
			drinkBuilder = BlackTeaBuilder.getDrinkBuilder();
			drinkBuilder.prepareDrink(order);
			break;
		case BLACK_COFFEE:
			drinkBuilder = BlackCoffeeBuilder.getDrinkBuilder();
			drinkBuilder.prepareDrink(order);
			break;
		default:
			System.out.println("Wrong choice");
			break;
		}
		rowsAffected = orderDAO.saveOrder(order);
		return rowsAffected;
	}

	@Override
	public void getTotalSales() {
		List<Order> orders = getOrders();
		double totalSale = 0.00;
		for (Order order : orders) {
			totalSale += order.getTotalAmount();
		}
		System.out.println("Total Sales are :"+totalSale);
	}

}
