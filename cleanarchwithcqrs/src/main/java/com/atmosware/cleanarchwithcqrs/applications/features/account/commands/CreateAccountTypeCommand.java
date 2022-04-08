package com.atmosware.cleanarchwithcqrs.applications.features.account.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAccountTypeCommand {
	
	@TargetAggregateIdentifier
	private String accountTypeId;

	private String accountName;

	private double price;

	private String description;

}
