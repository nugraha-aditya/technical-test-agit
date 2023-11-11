package com.example.technicaltestagit.account.repository;

import com.example.technicaltestagit.account.dto.CustomerTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTransactionsRepository extends JpaRepository<CustomerTransactions, String> {
}
