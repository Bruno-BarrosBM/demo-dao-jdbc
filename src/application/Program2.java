package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DaoFactory;
import dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Teste 1: department findByID ===");
		Department department = departmentDao.findById(3);
		
		System.out.println(department);
		
		System.out.println("\n=== Teste 2: department findAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("\n=== Teste 3: department insert ===");
		Department newDepartment = new Department(null, "Food");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());
		
		System.out.println("\n=== Teste 4: department update ===");
		department = departmentDao.findById(6);
		department.setName("Clothes");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== Teste 5: department delete ===");
		System.out.println("Enter id for delete test:");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
