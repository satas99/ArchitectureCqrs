package com.atmosware.cleanarchwithcqrs.applications.features.account.queries.getid;

import lombok.Data;

@Data
public class GetByIdAccountTypesQuery {
	private String accountTypeId;
}
