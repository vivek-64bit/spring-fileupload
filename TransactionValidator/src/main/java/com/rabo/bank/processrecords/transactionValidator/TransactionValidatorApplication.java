package com.rabo.bank.processrecords.transactionValidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rabo.bank.processrecords.*")
public class TransactionValidatorApplication  //extends SpringBootServletInitializer{
{
  public static void main(String[] args) {
    SpringApplication.run(TransactionValidatorApplication.class, args);
  }

}
