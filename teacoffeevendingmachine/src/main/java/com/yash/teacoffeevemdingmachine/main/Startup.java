package com.yash.teacoffeevemdingmachine.main;

import java.util.Scanner;

import com.yash.teacoffeevemdingmachine.dao.ContainerDAO;
import com.yash.teacoffeevemdingmachine.dao.OrderDAO;
import com.yash.teacoffeevemdingmachine.daoimpl.ContainerDAOImpl;
import com.yash.teacoffeevemdingmachine.daoimpl.OrderDAOImpl;
import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.enumeration.Drink;
import com.yash.teacoffeevemdingmachine.service.ContainerService;
import com.yash.teacoffeevemdingmachine.service.OrderService;
import com.yash.teacoffeevemdingmachine.serviceimpl.ContainerServiceImpl;
import com.yash.teacoffeevemdingmachine.serviceimpl.OrderServiceImpl;
import com.yash.teacoffeevemdingmachine.util.JsonUtil;

public class Startup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ContainerDAO containerDAO = ContainerDAOImpl.getInstance();
		ContainerService containerService = new ContainerServiceImpl(containerDAO);
		OrderDAO orderDAO = new OrderDAOImpl();
		OrderService orderService = new OrderServiceImpl(orderDAO);
		int choice;
		int noOfCups;
		String continueChoice;
		do {
			JsonUtil.readMenu("mainMenu.txt");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter no. of Cups");
				noOfCups = scanner.nextInt();
				orderService.addOrder(new Order(noOfCups, Drink.TEA));
				break;
			case 2:
				System.out.println("Enter no. of Cups");
				noOfCups = scanner.nextInt();
				orderService.addOrder(new Order(noOfCups, Drink.COFFEE));
				break;
			case 3:
				System.out.println("Enter no. of Cups");
				noOfCups = scanner.nextInt();
				orderService.addOrder(new Order(noOfCups, Drink.BLACK_TEA));
				break;
			case 4:
				System.out.println("Enter no. of Cups");
				noOfCups = scanner.nextInt();
				orderService.addOrder(new Order(noOfCups, Drink.BLACK_COFFEE));
				break;
			case 5:
				containerService.refillContainers();
				break;
			case 6:
				containerService.containerStatus();
				break;
			case 7:
				System.out.println("Thank you for using tea coffee vending machine");
				System.exit(0);
				break;
			}
			System.out.println("Do you want to continue?(yes/no)");
			continueChoice = scanner.next();
		} while (continueChoice.equalsIgnoreCase("yes"));
		scanner.close();
	}

}
