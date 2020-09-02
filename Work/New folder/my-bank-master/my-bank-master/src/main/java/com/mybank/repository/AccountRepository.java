package com.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybank.entity.AccountEntity;


@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
