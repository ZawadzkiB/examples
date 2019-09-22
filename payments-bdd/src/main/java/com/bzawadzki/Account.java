package com.bzawadzki;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

  private BigDecimal accountBalance;
  private List<BigDecimal> operations = new ArrayList<>();

  public Account(BigDecimal accountBalance) {
    this.accountBalance = accountBalance;
  }

  public void withdraw(BigDecimal amount) {
    if(accountBalance.compareTo(amount)<0){
      throw new IllegalStateException("Not enough money on account");
    }
    this.accountBalance = this.accountBalance.subtract(amount);
    this.operations.add(amount);
  }

  public BigDecimal getAccountBalance() {
    return this.accountBalance;
  }

  public BigDecimal getLastWithdrawal() {
    return operations.get(operations.size()-1);
  }

  public List<BigDecimal> getOperations() {
    return this.operations;
  }
}
