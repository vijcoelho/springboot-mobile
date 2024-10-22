package com.cotuca.account.repositories;

import com.cotuca.account.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> { }
