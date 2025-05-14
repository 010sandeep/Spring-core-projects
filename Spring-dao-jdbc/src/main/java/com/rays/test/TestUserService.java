package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt service = null;

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

//		 test.testAdd();
//		 test.testUpdate();
//		 test.testDelete();
//		 test.testFindByPk();
//		 test.testAuth();
		test.testSearch();

	}

	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("xyz");
		dto.setLastName("xyz");
		dto.setLogin("admin");
		dto.setPassword("pass1234");
		long pk = service.add(dto);
		System.out.println("Data Inserted... pk = " + pk);
	}

	public void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("sandeep");
		dto.setLastName("Gurjar");
		dto.setLogin("sandeep202@gmail.com");
		dto.setPassword("pass123");
		service.update(dto);
		System.out.println("Data updated = " + dto.getId());
	}

	private void testDelete() {
		service.delete(2);
		
		System.out.println("data deleted ..");
	}

	public void testFindByPk() {
		UserDTO dto = service.findByPK(1);
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("User ID not exist..!!!");
		}
	}

	public void testAuth() {
		UserDTO dto = service.authenticate("sandee02@gmail.com", "pass123");
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("User not exist");
		}
	}

	public void testSearch() {

		UserDTO dto = new UserDTO();

		List<UserDTO> list = service.search(dto, 0, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		}
	}
}