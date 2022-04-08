package com.atmosware.cleanarchwithcqrs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "products")
@Builder
public class Product {

	@Id
	@Column(name="id")
	private String productId;

	@Column(name="productName")
	private String productName;
	
	@Column(name="price")
	private double price;

	@Column(name="description")
	private String description;
}
