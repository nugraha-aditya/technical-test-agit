package com.example.technicaltestagit.account.service;

import com.example.technicaltestagit.account.dto.CustomerAccount;
import com.example.technicaltestagit.account.exception.CustomerAccountNotFoundException;
import com.example.technicaltestagit.account.repository.CustomerAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerAccountService {

    private final CustomerAccountRepository customerAccountRepository;

    public CustomerAccount findAccountByAccountNumber(String accountNumber) {
        Optional<CustomerAccount> optionalCustomerAccount = customerAccountRepository.findById(accountNumber);
        return optionalCustomerAccount.orElseThrow(() ->
                new CustomerAccountNotFoundException("Customer Account Number Not Found"));
    }

    @Transactional
    public void saveUpdatedAccount(CustomerAccount updatedCustomerAccount) {
        try {
            customerAccountRepository.save(updatedCustomerAccount);
        } catch (ObjectOptimisticLockingFailureException exception) {
            CustomerAccount customerAccount = this.findAccountByAccountNumber(updatedCustomerAccount.getAccountNumber());
            customerAccount.setBalance(updatedCustomerAccount.getBalance());
            this.saveUpdatedAccount(customerAccount);
        }
    }
}
