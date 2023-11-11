package com.example.technicaltestagit.account.controller;

import com.example.technicaltestagit.account.dto.AccountTransferForm;
import com.example.technicaltestagit.account.dto.CustomerAccount;
import com.example.technicaltestagit.account.service.CustomerAccountService;
import com.example.technicaltestagit.account.service.CustomerTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class CustomerAccountController {

    private final CustomerAccountService customerAccountService;
    private final CustomerTransactionService customerTransactionService;

    @GetMapping(value = "/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CustomerAccount> checkAccountBalance(@PathVariable("accountNumber") String accountNumber) {
        CustomerAccount customerAccount = customerAccountService.findAccountByAccountNumber(accountNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerAccount);
    }

    @PostMapping(value = "/{sourceAccountNumber}/transfer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity transferBalance(@PathVariable("sourceAccountNumber") String sourceAccountNumber,
                                          @RequestBody AccountTransferForm accountTransferForm) {
        customerTransactionService.processTransferBalance(accountTransferForm, sourceAccountNumber);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
