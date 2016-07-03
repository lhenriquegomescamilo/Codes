package br.com.sistema.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistema.dao.EmployeeDAO;
import br.com.sistema.domain.Employee;

public class EmployeeDaoTest {
	
	@Test
	@Ignore
	public void saveTest(){
		EmployeeDAO dao = new EmployeeDAO();
		
		dao.save(new Employee("Maikon", "573.102.224-06", "99360225", "Estudante"));
	}
	
	@Test
	@Ignore
	public void updateTest(){
		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = new Employee();
		
		employee.setCode(24L);
		employee.setCpf("835.854.120-17");
		employee.setFunction("Geografo");
		employee.setName("Jessica");
		employee.setPassword("123456789");
		
		dao.update(employee);
	}
	
	@Test
	@Ignore
	public void deleteIdentifier(){
		EmployeeDAO dao = new EmployeeDAO();
		dao.delete(6L);
	}
	
	@Test
	@Ignore
	public void deleteEmployeeTest(){
		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = dao.search(24L);
		
		dao.delete(employee);
	}
	
	@Test
	@Ignore
	public void searchTest(){
		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = dao.search(7L);
		
		System.out.println(employee);
	}
	
	@Test
	@Ignore
	public void findAllTest(){
		new EmployeeDAO().findAll().stream().forEach(f -> System.out.println(f));
	}
}
