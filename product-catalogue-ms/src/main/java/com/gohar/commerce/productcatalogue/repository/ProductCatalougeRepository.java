package com.gohar.commerce.productcatalogue.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gohar.commerce.productcatalogue.entity.Product;
import com.gohar.commerce.productcatalogue.entity.WarehouseLocation;

@Repository
public interface ProductCatalougeRepository extends MongoRepository<Product, String> {
	
//	Product findById(String id);

	Product save (Product product);
	
	Optional<Product> findByProductId(String productId);
	
//	List<Product> findByProductId(String productId);

	List<Product> findByWarehouseLocation(WarehouseLocation warehouseLocation);

	List<Product> findByProductName(String productName);
	
	List<Product> findByProductNameLikeAllIgnoreCase(String productName);
	/*
	 * List<Student> findByName(String name);
	 * Student findByEmailAndName (String email, String name);
	 * Student findByNameOrEmail (String name, String email);
	 * List<Student> findByDepartmentDepartmentName(String deptname);
	 * List<Student> findBySubjectsSubjectName (String subName);
	 * List<Student> findByEmailIsLike (String email);
	 * List<Student> findByNameStartsWith (String name);
	 */
}
