package com.gohar.commerce.productcatalogue.service;

import java.util.Collection;
import java.util.List;

import com.gohar.commerce.productcatalogue.entity.Product;


public interface IProductCatalougeService {

	Product fetchProductInfo(String productId);

	Product createNewProduct(Product product);
	
	int createBulkProduct(int start, int count);

	Collection<Product> fetchProductInfoByName(String productName);

	Collection<Product> findByProductNameLikeAllIgnoreCase(String productName);

}
