package com.atmosware.cleanarchwithcqrs.applications.features.account.queries.getid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atmosware.cleanarchwithcqrs.applications.features.account.queries.getall.GetAccountTypesDto;
import com.atmosware.cleanarchwithcqrs.applications.features.account.queries.getall.GetAccountTypesQuery;
import com.atmosware.cleanarchwithcqrs.domain.AccountType;
import com.atmosware.cleanarchwithcqrs.persistence.AccountTypeRepository;

@Component
public class GetByIdAccountTypesQueryHandler {
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public GetByIdAccountTypesQueryHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}

	@QueryHandler
	public GetByIdAccountTypesDto getByIdAccountTypes(GetByIdAccountTypesQuery getByIdAccountTypesQuery) {
		System.out.println(getByIdAccountTypesQuery.getAccountTypeId()+"getById");
		AccountType accountTypes = this.accountTypeRepository.findById(getByIdAccountTypesQuery.getAccountTypeId()).get();
		System.out.println(accountTypes.getAccountTypeId());
		GetByIdAccountTypesDto result = new GetByIdAccountTypesDto();
		BeanUtils.copyProperties(accountTypes, result);
		System.out.println(accountTypes.getAccountName());
		return result;
	}
}
