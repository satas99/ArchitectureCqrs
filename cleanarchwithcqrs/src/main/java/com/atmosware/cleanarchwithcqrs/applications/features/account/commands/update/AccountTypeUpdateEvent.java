package com.atmosware.cleanarchwithcqrs.applications.features.account.commands.update;

import lombok.Data;

@Data
public class AccountTypeUpdateEvent {
	
	private String accountTypeId;
	
	private double price;

	private String description;
}
