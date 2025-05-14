package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultipleXML {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("user.xml", "person.xml");

		User user = (User) context.getBean("user");

		Person person = (Person) context.getBean("person");

//		System.out.println("name = " + person.getName());

		System.out.println("login = " + user.getLogin());

		System.out.println("password= " + user.getPassword());

	}
}