package com.atmosware.cleanarchwithcqrs.applications.features.account.queries.getid;

import com.atmosware.cleanarchwithcqrs.applications.features.account.queries.getall.GetAccountTypesDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdAccountTypesDto {
	private String accountTypeId;

	private String accountName;

	private double price;

	private String description;
}
