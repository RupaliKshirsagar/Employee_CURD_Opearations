package com.curdexample.employeecrudoperations;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeecrudoperationsApplicationTests {


	@Test
	@Order(1)
	void contextLoads() {
	}
	@Test
	@Order(2)
	public void testcreateEmployee() throws URISyntaxException {

		Employee employee=new Employee(6,"Akshay","Kolhapur",50000);
		String expected="{\n" +
				"    \"empId\": 6,\n" +
				"    \"empName\": \"Akshay\",\n" +
				"    \"empAddress\": Kolhapur,\n" +
				"    \"empSalary\": \"50000\"\n" +
				"}";
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Employee> request =new HttpEntity<Employee>(employee,headers);
		String url="http://localhost:8080/addEmp";
		URI uri=new URI(url);
		ResponseEntity<String> response=restTemplate.postForEntity(uri, request,String.class);
		Assertions.assertEquals(200,response.getStatusCodeValue());


	}

	@Test
	@Order(3)
	public void testgetAllEmployee() throws URISyntaxException {
		System.out.println("The Test Started");
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/findAllEmp";
		URI uri=new URI(url);
		ResponseEntity<String> responseEntity=restTemplate.getForEntity(uri,String.class);
		Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
	}
	@Test
	@Order(4)
	public void testgetEmployee() throws URISyntaxException {
		System.out.println("The Test Started");
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/findEmpWithId/3";
		URI uri=new URI(url);
		ResponseEntity<String> responseEntity=restTemplate.getForEntity(uri,String.class);
		Assertions.assertEquals(200,responseEntity.getStatusCodeValue());

	}
	@Test
	@Order(5)
	public void testupdateEmployee() throws URISyntaxException {
		new Employee(6,"Akshay","Kolhapur",50000);

		String expected="{\n" +
				"    \"empId\": 6,\n" +
				"    \"empName\": \"Akshay\",\n" +
				"    \"empAddress\": Kolhapur,\n" +
				"    \"empSalary\": \"50000\"\n" +
				"}";
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Employee employee = new Employee();
		HttpEntity<Employee> request =new HttpEntity<Employee>(employee,headers);
		String url="http://localhost:8080/updateEmp/6";
		URI uri=new URI(url);
		ResponseEntity<String> response=restTemplate.exchange(uri, HttpMethod.PUT, request,String.class);
		Assertions.assertEquals(200,response.getStatusCodeValue());

	}
	@Test
	@Order(6)
	public void testdeleteEmployee() throws URISyntaxException {
	//	new Employee(6,"Akshay","Kolhapur",50000);

		Employee employee=new Employee(6,"Akshay","Kolhapur",50000);
		String expected="{\n" +
				"    \"empId\": 6,\n" +
				"    \"empName\": \"Akshay\",\n" +
				"    \"empAddress\": Kolhapur,\n" +
				"    \"empSalary\": \"50000\"\n" +
				"}";
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Employee> request =new HttpEntity<Employee>(employee,headers);
		String url="http://localhost:8080/deleteEmp/6";
		URI uri=new URI(url);
		ResponseEntity<String> response=restTemplate.exchange(uri, HttpMethod.DELETE, request,String.class);
		Assertions.assertEquals(200,response.getStatusCodeValue());

	}


}
