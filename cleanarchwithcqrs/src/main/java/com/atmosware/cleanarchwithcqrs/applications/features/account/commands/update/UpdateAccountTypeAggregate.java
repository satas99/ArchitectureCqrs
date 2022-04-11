package com.atmosware.cleanarchwithcqrs.applications.features.account.commands.update;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.atmosware.cleanarchwithcqrs.applications.features.account.commands.create.AccountTypeCreatedEvent;
import com.atmosware.cleanarchwithcqrs.applications.features.account.commands.create.CreateAccountTypeCommand;

@Aggregate
public class UpdateAccountTypeAggregate {
	@AggregateIdentifier
	private String accountTypeId;

	public UpdateAccountTypeAggregate() {

	}
	@CommandHandler
	public UpdateAccountTypeAggregate(UpdateAccountTypeCommand command) {
		AccountTypeUpdateEvent accountTypeUpdateEvent = new AccountTypeUpdateEvent();

		BeanUtils.copyProperties(command, accountTypeUpdateEvent);

		AggregateLifecycle.apply(accountTypeUpdateEvent);

	}

	@EventSourcingHandler
	public void on(AccountTypeUpdateEvent accountTypeUpdateEvent) {
		this.accountTypeId = accountTypeUpdateEvent.getAccountTypeId();
	}
}
