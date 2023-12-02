package com.gohar.commerce.productcatalogue.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.UUID;

import javax.swing.text.html.HTML;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gohar.commerce.productcatalogue.entity.Dimension;
import com.gohar.commerce.productcatalogue.entity.Product;
import com.gohar.commerce.productcatalogue.entity.WarehouseLocation;
import com.gohar.commerce.productcatalogue.repository.ProductCatalougeRepository;
import com.gohar.commerce.productcatalogue.service.IProductCatalougeService;
import com.horussoft.healthcare.common.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductCatalougeService implements IProductCatalougeService {

	private static final Logger logger = LoggerFactory.getLogger(IProductCatalougeService.class);

	private ProductCatalougeRepository productCatalougeRepository;

	@Override
	public Product fetchProductInfo(String productId) {
		Product product = productCatalougeRepository.findByProductId(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

		logger.info("product.getProductId() : {}", product.getProductId());

		return product;
	}

	@Override
	public Product createNewProduct(Product product) {
		logger.info("createNewProduct(START) : {}", product);

		Product savedProduct = productCatalougeRepository.save(product);
		logger.info("createNewProduct.getProductId() : {}", savedProduct.getProductId());
		return savedProduct;
	}

	@Override
	public Collection<Product> fetchProductInfoByName(String productName) {
		Collection<Product> products = productCatalougeRepository.findByProductName(productName);
		logger.info("product : {}", products);
		return products;
	}

	private int generateRandomNumber(int low, int high) {
		return new Random().nextInt(high - low) + low;
	}

	@Override
	public int createBulkProduct(int start, int count) {

		int end = start + count;
		HTML.Tag[] htmlTags = HTML.getAllTags();

		for (int i = start; i < end; i++) {
			Product p = new Product();
			p.setProductId(String.valueOf(i));
			p.setProductName(UUID.randomUUID().toString());
			p.setPrice(start * Math.random());
			generateRandomNumber(0, htmlTags.length - 1);
			p.setDimensions(new Dimension(Math.random(), Math.random(), Math.random()));
			ArrayList<String> tags = new ArrayList<>();
			for (int j = 0; j < generateRandomNumber(0, 6); j++) {
				tags.add(htmlTags[j].toString());
			}
			p.setTags(tags);
			p.setWarehouseLocation(new WarehouseLocation(Math.random(), Math.random()));
			createNewProduct(p);

		}
		return end;
	}

	@Override
	public Collection<Product> findByProductNameLikeAllIgnoreCase(String productName) {
		Collection<Product> products = productCatalougeRepository.findByProductNameLikeAllIgnoreCase(productName);
		logger.info("product : {}", products);
		return products;
	}

}
