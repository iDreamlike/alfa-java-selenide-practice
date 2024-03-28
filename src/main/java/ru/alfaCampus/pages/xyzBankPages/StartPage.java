package ru.alfaCampus.pages.xyzBankPages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class StartPage {
    private String bankName = "//strong[@class='mainHeading']";
    private String customerLoginBtn = "//button[@ng-click='customer()']";

    public StartPage checkBankName(String expectedBankName) {
        $x(bankName).shouldHave(text(expectedBankName));
        return this;
    }

    public CustomerLoginPage clickCustomerLoginBtn() {
        $x(customerLoginBtn).click();
        return Selenide.page(CustomerLoginPage.class);
    }
}
