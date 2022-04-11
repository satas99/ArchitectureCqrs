package com.atmosware.cleanarchwithcqrs.applications.features.account.queries.getall;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAccountTypesDto {

	private String accountTypeId;

	private String accountName;

	private double price;

	private String description;
}
