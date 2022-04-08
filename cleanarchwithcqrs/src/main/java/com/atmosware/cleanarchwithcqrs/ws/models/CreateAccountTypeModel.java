package com.atmosware.cleanarchwithcqrs.ws.models;

import lombok.Data;

@Data
public class CreateAccountTypeModel {

	private String accountName;

	private double price;

	private String description;
}
