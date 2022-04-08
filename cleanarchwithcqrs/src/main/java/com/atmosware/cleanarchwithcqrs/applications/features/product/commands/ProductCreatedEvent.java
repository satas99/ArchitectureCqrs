package com.atmosware.cleanarchwithcqrs.applications.features.product.commands;

import lombok.Data;

@Data
public class ProductCreatedEvent {

	private String productId;

	private String productName;

	private double price;

	private String description;
}
