package com.gohar.commerce.productcatalogue.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "product")
public class Product {

	@Id
	private String id;
	
	@Field(name = "productId")
	private String productId;

	@NotNull
    @Size(min = 5,max = 200, message = "Product Name length must be between 5 and 100 characters")
	@Field(name = "productName")
	private String productName;
	
	@Field(name = "price")
	private Double price;
	
	private Dimension dimensions;

	private List<String> tags;
	
	private WarehouseLocation warehouseLocation;
	/*
	 * {
    
      "productId": 1,
    
      "productName": "An ice sculpture",
    
      "price": 12.50,
    
      "tags": [ "cold", "ice" ],
    
      "dimensions": {
    
        "length": 7.0,
    
        "width": 12.0,
    
        "height": 9.5
    
      },
    
      "warehouseLocation": {
    
        "latitude": -78.75,
    
        "longitude": 20.4
    
      }
    
    }
    
	 * */

	
}
