package com.atmosware.cleanarchwithcqrs.applications.features.account.queries.getall;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atmosware.cleanarchwithcqrs.domain.AccountType;
import com.atmosware.cleanarchwithcqrs.persistence.AccountTypeRepository;

@Component
public class GetAccountTypesQueryHandler {
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public GetAccountTypesQueryHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	@QueryHandler
	public List<GetAccountTypesDto> getAllAccountTypes(GetAccountTypesQuery getAccountTypesQuery){
		List<GetAccountTypesDto> result = new ArrayList<>();
		
		List<AccountType> accountTypes = this.accountTypeRepository.findAll();
		
		for (AccountType accountType : accountTypes) {
			GetAccountTypesDto getAccountTypesDto = new GetAccountTypesDto();
			BeanUtils.copyProperties(accountType, getAccountTypesDto);
			result.add(getAccountTypesDto);
		}
		
		return result;
	}
	
}
