package com.gohar.commerce.productcatalogue.entity;

import org.springframework.data.mongodb.core.mapping.Field;

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

public class WarehouseLocation {

	@Field(name = "latitude")
	private Double latitude;
	@Field(name = "longitude")
	private Double longitude;

}
