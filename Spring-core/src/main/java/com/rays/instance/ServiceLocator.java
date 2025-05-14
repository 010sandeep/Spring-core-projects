package com.rays.instance;

public class ServiceLocator {

	private static ServiceLocator instance;

	private ServiceLocator() {
		
		System.out.println("sandeep");
	}

	public static ServiceLocator getInstance() {
		if (instance == null) {
			instance = new ServiceLocator();
			
			System.out.println("shivkant");
		}
		return instance;
	}
}