package com.atmosware.cleanarchwithcqrs.ws.controllers;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atmosware.cleanarchwithcqrs.applications.features.account.commands.CreateAccountTypeCommand;
import com.atmosware.cleanarchwithcqrs.ws.models.CreateAccountTypeModel;

@RestController
@RequestMapping("/accounttypes")
public class AccountTypesController {
	
	private CommandGateway commandGateway;
	private QueryGateway queryGateway;
	
	@Autowired
	public AccountTypesController(CommandGateway commandGateway, QueryGateway queryGateway) {
		this.commandGateway = commandGateway;
		this.queryGateway = queryGateway;
	}
	@PostMapping
	public void createAccountType(@RequestBody CreateAccountTypeModel createAccountTypeModel) {
		CreateAccountTypeCommand command = CreateAccountTypeCommand.builder()
				.price(createAccountTypeModel.getPrice())
				.accountName(createAccountTypeModel.getAccountName())
				.description(createAccountTypeModel.getDescription())
				.build();
		command.setAccountTypeId(UUID.randomUUID().toString());
		this.commandGateway.sendAndWait(command);
	}
	
}
