package Service;

import java.util.List;


import com.javatechie.spring.mongo.api.model.Employee;



public interface EmployeeService {
	
	 List<Employee> findAll();

	 List<Employee> findByPeriod(int leavePeriod ,int hiredPeriod);
  
	    List<Employee> findAllByCompany(String company);
	    
	    float netpay ( int period, int grosSalary);

	    Employee saveOrUpdateEmployee(Employee employee);

	    void deleteEmployeeById(int id);

}
