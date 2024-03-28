package ru.alfaCampus.pages.swagLabsPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private String userNameField = "//input[@data-test='username']";
    private String passwordField = "//input[@data-test='password']";
    private String loginBtn = "//input[@name='login-button']";
    private String errorContainer = ".error-message-container";

    public LoginPage inputLogin(String login) {
        $x(userNameField).setValue(login);
        return this;
    }

    public LoginPage inputPassword(String password) {
        $x(passwordField).setValue(password);
        return this;
    }

    public ProductsPage submit() {
        $x(loginBtn).click();
        return page(ProductsPage.class);
    }

    public LoginPage errSubmit() {
        $x(loginBtn).click();
        return this;
    }

    public LoginPage checkErrorContainerIsVisible() {
        $(errorContainer).shouldBe(visible);
        return this;
    }

    public LoginPage checkErrorContainerText(String text) {
        $(errorContainer).shouldHave(text(text));
        return this;
    }
}
