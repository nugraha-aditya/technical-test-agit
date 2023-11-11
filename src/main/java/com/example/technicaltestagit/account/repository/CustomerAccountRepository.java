package com.example.technicaltestagit.account.repository;

import com.example.technicaltestagit.account.dto.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, String> {
}
