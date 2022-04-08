package com.atmosware.cleanarchwithcqrs.applications.features.product.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CreateProductCommand {
	
	@TargetAggregateIdentifier
	private String productId;

	private String productName;

	private double price;

	private String description;
}
