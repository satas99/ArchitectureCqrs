package com.atmosware.cleanarchwithcqrs.applications.features.account.commands.update;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAccountTypeCommand {
	@TargetAggregateIdentifier
	private String accountTypeId;
	
	private double price;

	private String description;
}
