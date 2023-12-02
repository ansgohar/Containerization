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
public class Dimension {

	@Field(name = "length")
	private Double length;
	@Field(name = "width")
	private Double width;
	@Field(name = "height")
	private Double height;

}
