package com.example.technicaltestagit.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Table(name = "customer_account")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerAccount {

    @Id
    @JsonProperty(value = "account_number")
    private String accountNumber;
    @JsonProperty(value = "customer_name")
    private String customerName;
    private BigInteger balance;
}
