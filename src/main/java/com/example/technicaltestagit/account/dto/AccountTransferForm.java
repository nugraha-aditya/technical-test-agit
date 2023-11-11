package com.example.technicaltestagit.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountTransferForm {
    @JsonProperty(value = "to_account_number")
    private String ToAccountNumber;
    @JsonProperty(value = "amount")
    private BigInteger amount;
}
