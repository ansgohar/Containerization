package com.gohar.commerce.productcatalogue.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.UUID;

import javax.swing.text.html.HTML;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gohar.commerce.productcatalogue.entity.Dimension;
import com.gohar.commerce.productcatalogue.entity.Product;
import com.gohar.commerce.productcatalogue.entity.WarehouseLocation;
import com.gohar.commerce.productcatalogue.service.IProductCatalougeService;
import com.horussoft.healthcare.common.dto.ErrorResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "REST API for Product Catalouge Controller", description = "REST API for Product Cataloug to FETCH Product Cataloug details")
@RestController
@RequestMapping(path = "/api/product", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
public class ProductCatalougeController {

	private final IProductCatalougeService iProductCatalougeService;

	public ProductCatalougeController(IProductCatalougeService iProductCatalougeService) {
		this.iProductCatalougeService = iProductCatalougeService;
	}

	@Operation(summary = "Fetch Prouct Details  REST API", description = "REST API to fetch Product details based on product name")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@GetMapping()
	public ResponseEntity<Collection<Product>> fetchProductDetails(@RequestParam
//			@Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits") 
	String productName) {
		Collection<Product> products = iProductCatalougeService.fetchProductInfoByName(productName);
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	@Operation(summary = "Fetch Prouct Details  REST API", description = "REST API to fetch Product details based on product name")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@GetMapping("/like")
	public ResponseEntity<Collection<Product>> fetchProductDetailsLike(@RequestParam
//			@Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits") 
	String productName) {
		Collection<Product> products = iProductCatalougeService.findByProductNameLikeAllIgnoreCase(productName);
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	

	@Operation(summary = "Create Customer Details  REST API", description = "REST API to Create Product")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@PostMapping()
	public ResponseEntity<Product> saveDetails(@Valid @RequestBody Product product) {
		Product savedProduct = iProductCatalougeService.createNewProduct(product);
		return ResponseEntity.status(HttpStatus.OK).body(savedProduct);
	}

	@Operation(summary = "BULK Create Customer Details  REST API", description = "REST API to BULK Create Product")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@PostMapping("/bulk/{start}/{count}")
	public ResponseEntity<Object> saveBULKDetails(@PathVariable int start, @PathVariable int count) {
		LocalDateTime stTime = LocalDateTime.now();
		int end = iProductCatalougeService.createBulkProduct(start, count);
		LocalDateTime etTime = LocalDateTime.now();

		return ResponseEntity.status(HttpStatus.OK).body(count + " Product records Created Successfully in "
				+ (etTime.compareTo(stTime)) + " m Secs, Last item is " + end);
	}

}
