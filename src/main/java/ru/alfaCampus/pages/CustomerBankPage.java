package ru.alfaCampus.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.element;

public class CustomerBankPage {
    private String customerName = "//span[contains(@class, 'fontBig')]";
    private String depositBtn = "//button[@ng-click='deposit()']";
    private String amountInputField = "//input[@ng-model='amount']";
    private String submitBtn = "//button[@type='submit']";
    private String withdrawlBtn = "//button[@ng-click='withdrawl()']";
    private String message = "//span[@ng-show='message']";

    public CustomerBankPage checkCustomerName(String expectedCustomerName) {
        $x(customerName).shouldHave(text(expectedCustomerName));
        return this;
    }

    public CustomerBankPage makeDeposit(int amount) {
        $x(depositBtn).click();
        $x(amountInputField).setValue(String.valueOf(amount));
        $x(submitBtn).click();
        return this;
    }

    public CustomerBankPage withdrawlAmount(int amount){
        $x(withdrawlBtn).click();
        $x(amountInputField).setValue(String.valueOf(amount));
        $x(submitBtn).click();
        return this;
    }

    public CustomerBankPage checkMessage(String expectedMessage) {
        $x(message).shouldHave(text(expectedMessage));
        return this;
    }
}
