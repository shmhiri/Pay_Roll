package Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.spring.mongo.api.model.Employee;
import com.javatechie.spring.mongo.api.repository.*;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;
	
	  @Override
	    public List<Employee> findAll() {
	        return employeeRepository.findAll();
	    }
	  
	  @Override
	  public float netpay (int period,int grosSalary) {
		  
		  
			 String x = String.valueOf(period)  ;
			 
			 String substring = x.substring(Math.max(x.length() - 2, 0));
			 int i=Integer.parseInt(substring);  
			 
			 int seminet = grosSalary-((i/100)*grosSalary);
			 
		
		  if (seminet<=1000) {
			  
			 return seminet/1 ;
			  
		  }

	else if(seminet>=2000 && seminet<12000){
		return seminet = ((100-(seminet/705))/100)*seminet;
		
		
	}
		
	
	
	
	else if (seminet>12000) {
		
		return	  (float) ((float)seminet*0.83);
		
		   
		
	}
		  return  seminet;
		  
	  }
	  
	  @Override
	  public List<Employee> findByPeriod(int leavePeriod,int hiredPeriod){
		 
		  
		        return employeeRepository.findByleavePeriodLessThan(leavePeriod);
		    }
		  
	  @Override
	public
		    List<Employee> findAllByCompany(String company){
		        return employeeRepository.findAllByCompany(company);
		    }
		  
	  @Override
	public
		    Employee saveOrUpdateEmployee(Employee employee){
		  return employeeRepository.save(employee);
		    }
		  
	  @Override
	public
		    void deleteEmployeeById(int id){
		  employeeRepository.deleteById(id);
	        
	    }
	  


}




