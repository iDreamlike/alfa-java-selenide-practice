package ru.alfaCampus.utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    }
}
