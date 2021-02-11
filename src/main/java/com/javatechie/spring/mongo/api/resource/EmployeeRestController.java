package com.javatechie.spring.mongo.api.resource;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mongo.api.model.Company;
/*
import com.example.DTO.EmployeeDTO;
import com.example.Service.EmployeeService;*/
import com.javatechie.spring.mongo.api.model.Employee;

import com.javatechie.spring.mongo.api.repository.EmployeeRepository;

import Service.EmployeeServiceImpl;

import java.util.List;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeRepository repository;
	
	private EmployeeServiceImpl  employeeService;
	
	
	 @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")  // 404
	 public class OrderNotFoundException extends RuntimeException {
	 
	 }
	 
	
	@GetMapping("/findAllEmployee/{period}")
	public @ResponseBody List<Employee> getpayroll(@RequestBody List<Employee> employee, @PathVariable int period) {
		Employee employe = null ;
		
				employeeService.netpay(employe.getGrosSalary(), period);
				
				
				return  repository.findAll();
	}
	

	

	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody Employee emp) {
		if (emp.getGrosSalary() == 0) {

			return "you didin't add gros salary for the  Employee please try one more time ";

		} else {
			emp.setPeriod(emp.getLeavePeriod() - emp.getHiredPeriod());
			repository.save(emp);
			return "Added Employee with id : " + emp.getId();
		}

	}

	@PutMapping("/updateEmployee/{id}")
	public Employee updateDEmployee(@RequestBody Employee employee, @PathVariable int id,
			HttpServletResponse response) {
		employee.setId(id);
		
		 

		

		 if (employee.getGrosSalary() == 0) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return employee;
		} else  {

			repository.save(employee);
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			return employee;

		}
		 
		 

	}
	
	//  if (order == null) throw new OrderNotFoundException(id);

	@GetMapping("/findAllEmployee")
	public List<Employee> getEmployee() {
		return repository.findAll();
	}

	@GetMapping("/findAllEmployees/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		
		
		return repository.findById(id);
	}

	@GetMapping("/findAllEmployeesPeriod/{hiredPeriod}")
	public List<Employee> getEmployeeByhiredPeriod(@PathVariable int hiredPeriod) {

		return repository.findByhiredPeriodGreaterThan(hiredPeriod);
	}

	@GetMapping("/findAllEmployeesPeriod/{leavePeriod}")
	public List<Employee> getEmployeeByleavePeriod(@PathVariable int leavePeriod) {

		return repository.findByleavePeriodLessThan(leavePeriod);
	}

	@GetMapping("/findAllEmployeesbyPeriod/{hiredPeriod}/{leavePeriod}")
	public List<Employee> getEmployeeByPeriod(@PathVariable int hiredPeriod, @PathVariable int leavePeriod) {

		return repository.findByPeriodBetween(hiredPeriod, leavePeriod);

	}

	@GetMapping("/findAllEmployeescomp/{company}")
	public List<Employee> getEmployeeByCompany(@PathVariable String company) {

		return repository.findAllByCompany(company);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		repository.deleteById(id);
		return "Employee deleted with id : " + id;
	}

//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping(value = "/")
//    public List<EmployeeDTO> getAllEmployee() {
//        return ObjectMapperUtils.mapAll(employeeService.findAll(), EmployeeDTO.class);
//    }
//
//
//    @GetMapping(value = "/byfirstName/{firstName}")
//    public EmployeeDTO findByEmployeeFirstName(@PathVariable("firstName") String firstName) {
//        return ObjectMapperUtils.map(employeeService.findByEmployeeFirstName(firstName), EmployeeDTO.class);
//    }
//
//    @GetMapping(value = "/company/{company}")
//    public List<EmployeeDTO> findAllByCompany(@PathVariable("company") String company) {
//        return ObjectMapperUtils.mapAll(employeeService.findAllByCompany(company), EmployeeDTO.class);
//    }
//
//    @PostMapping(value = "/save")
//    public ResponseEntity<?> saveOrUpdateEmployee(@RequestBody EmployeeDTO employeeDTO) {
//    	employeeService.saveOrUpdateEmployee(ObjectMapperUtils.map(employeeDTO, Employee.class));
//        return new ResponseEntity("Employee added successfully", HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/delete/{name}")
//    public ResponseEntity<?> deleteEmployeeById(@PathVariable String name) {
//    	employeeService.deleteEmployeeById(employeeService.findByEmployeeFirstName(name).getId());
//        return new ResponseEntity("employee deleted successfully", HttpStatus.OK);
//    }

}