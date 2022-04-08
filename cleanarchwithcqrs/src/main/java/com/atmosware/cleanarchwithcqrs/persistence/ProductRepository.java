package com.atmosware.cleanarchwithcqrs.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atmosware.cleanarchwithcqrs.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
