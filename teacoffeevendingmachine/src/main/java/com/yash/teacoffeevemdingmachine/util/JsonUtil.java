package com.yash.teacoffeevemdingmachine.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.yash.teacoffeevemdingmachine.domain.Container;
import com.yash.teacoffeevemdingmachine.domain.Order;
import com.yash.teacoffeevemdingmachine.exception.FileDoesNotExistException;
import com.yash.teacoffeevemdingmachine.exception.FileEmptyException;

public class JsonUtil {

	private static final String FILE_PATH_CONTAINER_JSON = "src/main/resources/Container.json";
	private static final String FILE_PATH_ORDER_JSON = "src/main/resources/Order.json";

	public List<Container> readObjectFromJson() {
		List<Container> containers = null;
		Gson gson = new GsonBuilder().create();
		FileReader jsonFileReader;
		try {
			jsonFileReader = new FileReader(FILE_PATH_CONTAINER_JSON);
			BufferedReader bufferedReader = new BufferedReader(jsonFileReader);
			String jsonfromString = bufferedReader.readLine();
			if (jsonfromString != null) {
				containers = gson.fromJson(jsonfromString, new TypeToken<List<Container>>() {
				}.getType());
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return containers;
	}

	public void writeObjectToJson(List<Container> containerList) {
		Gson gson = new GsonBuilder().create();
	
			String containersJson = gson.toJson(containerList);
			FileWriter jsonFileWriter;
			try {
				jsonFileWriter = new FileWriter(FILE_PATH_CONTAINER_JSON);
				jsonFileWriter.write(containersJson);
				jsonFileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			
			
		
	}

	public static void writeJSONToFile(List<Order> orders) {
		Gson gson = new GsonBuilder().create();
			String ordersJson = gson.toJson(orders);
			FileWriter jsonFileWriter;
			try {
				jsonFileWriter = new FileWriter(FILE_PATH_ORDER_JSON);
				jsonFileWriter.write(ordersJson);
				jsonFileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
	}

	public static List<Order> readOrderJSONFromFile() {
		List<Order> orders = null;
		Gson gson = new GsonBuilder().create();
		File fileToBeRead = new File(FILE_PATH_ORDER_JSON);
		if (!fileToBeRead.exists()) {
			throw new FileDoesNotExistException("File does not exist");
		}

		if (fileToBeRead.length() <= 0) {
			throw new FileEmptyException("File is empty");
		}
		FileReader jsonFileReader;
		try {
			jsonFileReader = new FileReader(fileToBeRead);
			BufferedReader bufferedReader = new BufferedReader(jsonFileReader);
			String jsonfromString = bufferedReader.readLine();
			if (jsonfromString != null) {
				orders = gson.fromJson(jsonfromString, new TypeToken<List<Order>>() {
				}.getType());
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return orders;
	}

	public static void readMenu(String fileName) {
		
		File fileToRead = getFile(fileName);
		
		try {
			
			BufferedReader fileReader = new BufferedReader(new FileReader(fileToRead));
			
			String currentline;
			
			while ((currentline = fileReader.readLine()) != null) {
				System.out.println(currentline);
			}
			
			fileReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static File getFile(String fileName){
		
		try {
			File file = new File("src/main/resources/"+fileName);
			return file;
		} catch (Exception exception) {
			throw new FileDoesNotExistException("File does not exist");
		}
	  }
}
