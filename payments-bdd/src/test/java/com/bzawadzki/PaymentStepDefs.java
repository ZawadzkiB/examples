package com.bzawadzki;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PaymentStepDefs {

  private Account account;
  private List<Exception> exceptions = new ArrayList<>();

  @Given("account with {int} balance")
  public void accountWithBalance(Integer startBalance) {
    account = new Account(BigDecimal.valueOf(startBalance.longValue()));
  }

  @When("withdraw {int}")
  public void withdrawAmount(Integer amountToWithdraw) {
    try {
      account.withdraw(BigDecimal.valueOf(amountToWithdraw.longValue()));
    }catch (Exception e){
      exceptions.add(e);
    }
  }

  @Then("we get that {int}")
  public void weGetThatAmount(Integer amount) {
    assertEquals(account.getLastWithdrawal(), BigDecimal.valueOf(amount.longValue()));
  }

  @And("money left on our account is {int} minus {int}")
  public void moneyLeftOnOurAccountIsMinusAmount(Integer startBalance, Integer withdrawedAmount) {
    assertEquals(BigDecimal.valueOf((startBalance.longValue()-withdrawedAmount.longValue())),account.getAccountBalance());
  }

  @Then("error should be returned")
  public void errorShouldBeReturned() {
    assertEquals(exceptions.size(),1);
  }

  @And("account balance should be same as before")
  public void accountBalanceShouldBeSameAsBefore() {
    assertEquals(account.getAccountBalance(), BigDecimal.valueOf(200));
  }

  @And("last operation should be not created")
  public void lastOperationShouldBeNotCreated() {
    assertEquals(account.getOperations().size(),0);

  }
}
