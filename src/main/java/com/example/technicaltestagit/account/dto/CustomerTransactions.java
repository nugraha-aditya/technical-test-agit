package com.example.technicaltestagit.account.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "customer_transactions")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sourceAccount;
    private String destAccount;
    private BigInteger amount;
    private Date createdDate;
}
