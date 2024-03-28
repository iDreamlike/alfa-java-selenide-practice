package ru.alfaCampus.pages.xyzBankPages;

import com.codeborne.selenide.Selenide;
import ru.alfaCampus.utils.UserNames;

import static com.codeborne.selenide.Selenide.*;

public class CustomerLoginPage {
    private String loginBtn = "//button[@type='submit']";


    public CustomerBankPage loginWithUserName(UserNames userName) {
        $x("//option[text()='%s']".formatted(userName.getUserName())).click();
        $x(loginBtn).click();
        return Selenide.page(CustomerBankPage.class);
    }
}
