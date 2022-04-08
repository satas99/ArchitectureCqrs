package com.atmosware.cleanarchwithcqrs.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atmosware.cleanarchwithcqrs.domain.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, String>{

}
