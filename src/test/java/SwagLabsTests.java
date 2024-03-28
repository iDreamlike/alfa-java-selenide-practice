import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.alfaCampus.pages.swagLabsPages.LoginPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class SwagLabsTests {
    @BeforeAll
    public static void setUp() {
        baseUrl = "https://www.saucedemo.com/";
    }

    @Test
    public void checkSuccessLogin() {
        open(baseUrl, LoginPage.class)
                .inputLogin("standard_user")
                .inputPassword("secret_sauce")
                .submit()
                .checkInventoryListIsVisible();
    }

    @Test
    public void checkLockedOutUserLogin() {
        open(baseUrl, LoginPage.class)
                .inputLogin("locked_out_user")
                .inputPassword("secret_sauce")
                .errSubmit()
                .checkErrorContainerIsVisible()
                .checkErrorContainerText("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void checkInventoryItemsListSize() {
        open(baseUrl, LoginPage.class)
                .inputLogin("standard_user")
                .inputPassword("secret_sauce")
                .submit()
                .checkInventoryItemsListSize(6);
    }
}