	package com.javatechie.spring.mongo.api.repository;





	import org.springframework.data.mongodb.repository.MongoRepository;


	import com.javatechie.spring.mongo.api.model.Company;
	import java.util.List;

	public interface CompanyRepository extends MongoRepository<Company, Integer>{
		

					
		//	List<Company> findAllbyName(String name);
		

		}



