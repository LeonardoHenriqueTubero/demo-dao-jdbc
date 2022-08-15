package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		List<Department> list = new ArrayList<>();
		
		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(4);
		System.out.println(department);
		
		System.out.println("=== TEST 2: department insert ===");
		Department newDep = new Department(null, "teste");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id: " + newDep.getId());
		
		System.out.println("=== TEST 3: department update ===");
		department.setName("Teste2");
		departmentDao.update(department);
		System.out.println("Update complete!");
		
		System.out.println("=== TEST 4: department deleteById ===");
		System.out.println("Enter id for delate test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		System.out.println("=== TEST 5: department findAll ===");
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}

}
