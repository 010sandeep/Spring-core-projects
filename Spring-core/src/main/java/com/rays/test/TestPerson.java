package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("person.xml");

		Person person = (Person) context.getBean("person");

		System.out.println("name = " + person.getName());

	}

}
