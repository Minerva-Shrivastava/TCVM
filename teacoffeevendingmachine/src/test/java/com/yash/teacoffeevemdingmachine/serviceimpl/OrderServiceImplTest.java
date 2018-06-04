package com.yash.teacoffeevemdingmachine.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yash.teacoffeevemdingmachine.dao.OrderDAO;
import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.enumeration.Drink;
import com.yash.teacoffeevemdingmachine.exception.EmptyListException;
import com.yash.teacoffeevemdingmachine.exception.NullObjectException;
import com.yash.teacoffeevemdingmachine.service.OrderService;
import com.yash.teacoffeevemdingmachine.serviceimpl.OrderServiceImpl;

public class OrderServiceImplTest {

	OrderService orderService;
	OrderDAO orderDAO = mock(OrderDAO.class);
	Order order;

	@Before
	public void init() {
		orderService = new OrderServiceImpl(orderDAO);
	}

	@Test
	public void getOrders_ShouldReturnSizeOfOrdersList() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(3, Drink.TEA, true));
		when(orderDAO.getOrders()).thenReturn(orders);
		assertEquals(1, orderService.getOrders().size());
	}

	@Test(expected = NullObjectException.class)
	public void getOrders_ShouldThrowNullObjectException_WhenListReturnedIsNull() {
		List<Order> orders = null;
		when(orderDAO.getOrders()).thenReturn(orders);
		orderService.getOrders();
	}

	@Test(expected = EmptyListException.class)
	public void getOrdersByDrink_ShouldThrowEmptyException_WhenDrinkTypeIsGivenAndListReturnedIsEmpty() {
		List<Order> orders = new ArrayList<>();
		when(orderDAO.getOrdersByDrink(Drink.TEA)).thenReturn(orders);
		orderService.getOrdersByDrink(Drink.TEA);
	}
	
	@Test
	public void getOrdersByDrink_ShouldReturnSizeOfGivenDrinkOrdersList_WhenDrinkTypeIsGiven() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(3, Drink.TEA, true));
		when(orderDAO.getOrdersByDrink(Drink.TEA)).thenReturn(orders);
		assertEquals(1, orderService.getOrdersByDrink(Drink.TEA).size());
	}

	@Test(expected = NullObjectException.class)
	public void addOrder_shouldThrowNullObjectException_WhenOrderObjectIsNull() {
		order = null;
		orderService.addOrder(order);
	}

	@Test
	public void addOrder_shouldReturnOne_whenOrderObjectIsGiven() {
		order = new Order(1, Drink.TEA);
		when(orderDAO.saveOrder(order)).thenReturn(1);
		assertEquals(1, orderService.addOrder(order));
	}

}
