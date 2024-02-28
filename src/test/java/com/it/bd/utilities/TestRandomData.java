package com.it.bd.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.github.javafaker.Faker;

public class TestRandomData {
	static String firstName;
	static String lastName;
	public static void randomData() throws FileNotFoundException, IOException {
		Faker faker = new Faker();

		firstName = faker.name().firstName();
		lastName = faker.name().lastName();

		System.out.println(firstName);
		System.out.println(lastName);
		
		ExcelUtils testRandomData = new ExcelUtils();
		
		testRandomData.writeExcelData(firstName, lastName, "test", "1236410", "1616");

	}

}
