package com.atmosware.cleanarchwithcqrs.ws.controllers;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atmosware.cleanarchwithcqrs.applications.features.account.commands.create.CreateAccountTypeCommand;
import com.atmosware.cleanarchwithcqrs.applications.features.account.commands.update.UpdateAccountTypeCommand;
import com.atmosware.cleanarchwithcqrs.applications.features.account.queries.getall.GetAccountTypesDto;
import com.atmosware.cleanarchwithcqrs.applications.features.account.queries.getall.GetAccountTypesQuery;
import com.atmosware.cleanarchwithcqrs.applications.features.account.queries.getid.GetByIdAccountTypesDto;
import com.atmosware.cleanarchwithcqrs.applications.features.account.queries.getid.GetByIdAccountTypesQuery;
import com.atmosware.cleanarchwithcqrs.ws.models.CreateAccountTypeModel;
import com.atmosware.cleanarchwithcqrs.ws.models.UpdateAccountTypeModel;

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
	@PostMapping("add")
	public void createAccountType(@RequestBody CreateAccountTypeModel createAccountTypeModel) {
		CreateAccountTypeCommand command = CreateAccountTypeCommand.builder()
				.price(createAccountTypeModel.getPrice())
				.accountName(createAccountTypeModel.getAccountName())
				.description(createAccountTypeModel.getDescription())
				.build();
		command.setAccountTypeId(UUID.randomUUID().toString());
		this.commandGateway.sendAndWait(command);
	}
	
	@GetMapping("getall")
	public List<GetAccountTypesDto> getAll(){
		return this.queryGateway.query(new GetAccountTypesQuery(), ResponseTypes.multipleInstancesOf(GetAccountTypesDto.class)).join();
	}
	@GetMapping("getbyid")
	public GetByIdAccountTypesDto getById(@RequestBody GetByIdAccountTypesQuery getByIdAccountTypesQuery){
		System.out.println(getByIdAccountTypesQuery.getAccountTypeId());
		return this.queryGateway.query(getByIdAccountTypesQuery, ResponseTypes.instanceOf(GetByIdAccountTypesDto.class)).join();
	}
	@PostMapping("update")
	public void updateAccountType(@RequestBody UpdateAccountTypeModel updateAccountTypeModel) {
		CreateAccountTypeCommand command = CreateAccountTypeCommand.builder()
				.accountTypeId(updateAccountTypeModel.getAccountTypeId())
				.price(updateAccountTypeModel.getPrice())
				.description(updateAccountTypeModel.getDescription())
				.build();
		this.commandGateway.sendAndWait(command);
	}
	
}
