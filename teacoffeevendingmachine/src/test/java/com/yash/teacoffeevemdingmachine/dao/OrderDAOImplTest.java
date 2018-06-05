package com.yash.teacoffeevemdingmachine.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.yash.teacoffeevemdingmachine.dao.OrderDAO;
import com.yash.teacoffeevemdingmachine.daoimpl.OrderDAOImpl;
import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.enumeration.Drink;
import com.yash.teacoffeevemdingmachine.exception.FileDoesNotExistException;
import com.yash.teacoffeevemdingmachine.exception.NullObjectException;

public class OrderDAOImplTest {


	private OrderDAO orderDAO;

	@Before
	public void setUp() {
		orderDAO = new OrderDAOImpl();
	}

//	@Test(expected = FileDoesNotExistException.class)
//	public void getOrders_ShouldThrowFileDoesNotExistException_WhenJSONFileForOrderDoesNotExist() {
//		orderDAO.getOrders();
//	}

	@Test(expected = NullObjectException.class)
	public void saveOrder_shouldThrowException_WhenOrderObjectGivenIsNull() {
		Order order = null;
		assertEquals(1, orderDAO.saveOrder(order));
	}

	
	@Test
	public void saveOrder_ShouldReturnOne_WhenOrderObjectIsGiven() {
		Order order = new Order(5, Drink.TEA, true);
		assertEquals(1, orderDAO.saveOrder(order));
	}

	@Test
	public void getOrders_shouldReturnSizeOfOrdersList_WhenListOfOrderObjectAreInJSONFile() {
		
		assertEquals(2, orderDAO.getOrders().size());
	}

	
	@Test
	public void getOrdersByDrink_ShouldReturnSizeOfOrderList_WhenDrinkTypeIsGivenAndJSONFileHasOrdersOfGivenDrinkType() {
		assertEquals(1, orderDAO.getOrdersByDrink(Drink.TEA).size());
	}

	@Test
	public void getOrdersByDrink_ShouldReturnSizeOfOrderListAsZero_WhenDrinkTypeIsGivenAndJSONFileDoesntHasOrdersOfGivenDrinkType() {
		assertEquals(0, orderDAO.getOrdersByDrink(Drink.BLACK_COFFEE).size());
	}

}
