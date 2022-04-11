package com.atmosware.cleanarchwithcqrs.applications.features.account.commands.update;

import java.util.UUID;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atmosware.cleanarchwithcqrs.applications.features.account.commands.create.AccountTypeCreatedEvent;
import com.atmosware.cleanarchwithcqrs.domain.AccountType;
import com.atmosware.cleanarchwithcqrs.persistence.AccountTypeRepository;

import lombok.Data;

@Component
public class AccountTypeUpdateEventHandler {
	
	private AccountTypeRepository accountTypeRepository;
	
	@Autowired
	public AccountTypeUpdateEventHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	
	@EventHandler
	public void on(AccountTypeUpdateEvent accountTypeUpdateEvent) {
		AccountType accountType = accountTypeRepository.findById(accountTypeUpdateEvent.getAccountTypeId()).get();
		
		accountType.setDescription(accountTypeUpdateEvent.getDescription());
		accountType.setPrice(accountTypeUpdateEvent.getPrice());
		
	    accountTypeRepository.save(accountType);
	}
}
