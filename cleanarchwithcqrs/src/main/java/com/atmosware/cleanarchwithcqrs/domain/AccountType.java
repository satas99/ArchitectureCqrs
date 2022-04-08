package com.atmosware.cleanarchwithcqrs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "accountTypes")
public class AccountType {

	@Id
	@Column(name="id")
	private String accountTypeId;

	@Column(name="accountName")
	private String accountName;

	@Column(name="price")
	private double price;

	@Column(name="description")
	private String description;

}
