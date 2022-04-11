package com.atmosware.cleanarchwithcqrs.ws.models;

import lombok.Data;

@Data
public class UpdateAccountTypeModel {
	
	private String accountTypeId;
	
	private double price;

	private String description;
}
