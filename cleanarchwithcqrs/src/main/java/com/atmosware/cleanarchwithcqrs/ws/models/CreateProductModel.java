package com.atmosware.cleanarchwithcqrs.ws.models;

import lombok.Data;

@Data
public class CreateProductModel {
	
	private String productName;

	private double price;

	private String description;
}
