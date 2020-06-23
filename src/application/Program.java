package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("=================== CRUD DEPARTMENT =============================");
		System.out.println("==Test 1 : DEPARTMETN  findById ===");
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department departmentDep = departmentDao.findById(2);
		System.out.println("Departamento por id : " + departmentDep);
		
		System.out.println("==Test 2 : DEPARTMETN  findAll ===");
		List<Department> listDep = departmentDao.findAll();
		for(Department objDep : listDep) {
			System.out.println(objDep);
		}
		
		System.out.println("==Test 3 : DEPARTMETN  insert ===");
		Department newDepartment = new Department(null, "FOOD");
		departmentDao.insert(newDepartment);
		System.out.println("inserido");
		
		System.out.println("==Test 4 : DEPARTMETN  update ===");
		
		departmentDep = departmentDao.findById(2);
		departmentDep.setName("Telefonia");
		departmentDao.update(departmentDep);
		System.out.println("Atualizado");
		
		System.out.println("==Test 5 : DEPARTMETN  delete ===");
		System.out.println("enter id for deparment delete");
		int idDep = sc.nextInt();
		departmentDao.deleteById(idDep);
		
		System.out.println("Depatment deleted");
		
		System.out.println("=================== CRUD SELLER =============================");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==Test 1 : Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println("teste "+ seller);
		
		System.out.println("\n===Test 2 : Seller findByDeparment ===");
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===Test 3 : Seller findByDeparment ===");
		
		list = sellerDao.findAll();
		
		for(Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===Test 4 : Seller Insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted : " + newSeller.getId());
		
		
		System.out.println("\n===Test 5 : Seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha waine");
		sellerDao.update(seller);
		System.out.println("update completado");
		
		
		System.out.println("\n===Test 6 : Seller delete ===");
		
		System.out.println("Enter id for delete test");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("delete complete");
		sc.close();
	}

}
