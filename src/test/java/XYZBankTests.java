import ru.alfaCampus.pages.xyzBankPages.StartPage;
import ru.alfaCampus.utils.BaseTest;
import ru.alfaCampus.utils.UserNames;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class XYZBankTests extends BaseTest {

    @Test
    public void bankNameShouldBeXYZBank() {
        open(baseUrl, StartPage.class)
                .checkBankName("XYZ Bank");
    }

    @Test
    public void checkUserNamesAfterLogin() {
        for (UserNames userName : UserNames.values()) {
            open(baseUrl, StartPage.class)
                    .clickCustomerLoginBtn()
                            .loginWithUserName(userName)
                                    .checkCustomerName(userName.getUserName());
        }
    }

    @Test
    public void checkSuccessfulDepositAmount() {
        open(baseUrl, StartPage.class)
                .clickCustomerLoginBtn()
                .loginWithUserName(UserNames.HERMOINE_GRANGER)
                .makeDeposit(1000)
                .checkMessage("Deposit Successful");
    }

    @Test
    public void checkSuccessfulWithdrawlAmount() {
        open(baseUrl, StartPage.class)
                .clickCustomerLoginBtn()
                .loginWithUserName(UserNames.HERMOINE_GRANGER)
                .withdrawlAmount(1000)
                .checkMessage("Transaction successful");
    }
}
