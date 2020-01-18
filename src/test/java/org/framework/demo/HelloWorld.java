package org.framework.demo;

import org.framework.demo.resources.Xls_Reader;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World Baby:::");
		System.out.println("New Code:::");
		System.out.println("Adding a new line after creating a new branch");
		System.out.println("Added a New line again");
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Sagar\\eclipse-workspace\\demo\\src\\main\\java\\org\\framework\\demo\\resources\\ProvisioingFormData.xlsx", 1);
		System.out.println(reader.getCellData("logindetails", "partner name", 2));
	}

}
