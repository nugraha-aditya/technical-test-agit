package com.example.technicaltestagit.account.service;

import com.example.technicaltestagit.account.dto.AccountTransferForm;
import com.example.technicaltestagit.account.dto.CustomerAccount;
import com.example.technicaltestagit.account.dto.CustomerTransactions;
import com.example.technicaltestagit.account.exception.TransferBalanceInsufficientException;
import com.example.technicaltestagit.account.repository.CustomerTransactionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class CustomerTransactionService {

    private final CustomerAccountService customerAccountService;
    private final CustomerTransactionsRepository customerTransactionsRepository;

   @Transactional
    public void processTransferBalance(AccountTransferForm accountTransferForm, String sourceAccountNumber) {
        String destinationAccountNumber = accountTransferForm.getToAccountNumber();
        CustomerAccount sourceAccount = customerAccountService.findAccountByAccountNumber(sourceAccountNumber);
        CustomerAccount destinationAccount = customerAccountService.findAccountByAccountNumber(destinationAccountNumber);

        BigInteger transferAmount = accountTransferForm.getAmount();
        this.validateTransferBalance(sourceAccount, transferAmount);
        this.updateTransferOnAccounts(sourceAccount, destinationAccount, transferAmount);

        CustomerTransactions newTransaction = CustomerTransactions.builder()
                .sourceAccount(sourceAccountNumber)
                .destAccount(destinationAccountNumber)
                .amount(transferAmount)
                .createdDate(new Date())
                .build();
        customerTransactionsRepository.save(newTransaction);
    }

    private void validateTransferBalance(CustomerAccount sourceAccount, BigInteger transferAmount) {
        BigInteger currentBalance = sourceAccount.getBalance();
        boolean isCurrentBalanceInsufficient = currentBalance.compareTo(transferAmount) < 0;
        if (isCurrentBalanceInsufficient) {
            throw new TransferBalanceInsufficientException("Not enough balance on account");
        }
    }

    private void updateTransferOnAccounts(CustomerAccount sourceAccount,
                                            CustomerAccount destinationAccount,
                                            BigInteger transferAmount) {
        BigInteger sourceAccountBalance = sourceAccount.getBalance();
        BigInteger updatedSourceAccountBalance = sourceAccountBalance.subtract(transferAmount);
        sourceAccount.setBalance(updatedSourceAccountBalance);
        customerAccountService.saveUpdatedAccount(sourceAccount);

        BigInteger destinationAccountBalance = destinationAccount.getBalance();
        BigInteger updatedDestinationAccountBalance = destinationAccountBalance.add(transferAmount);
        destinationAccount.setBalance(updatedDestinationAccountBalance);
        customerAccountService.saveUpdatedAccount(destinationAccount);
    }
}
