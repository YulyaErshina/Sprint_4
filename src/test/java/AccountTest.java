import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.Account;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expBoolean;

    public AccountTest(String name, boolean expBoolean) {
        this.name = name;
        this.expBoolean = expBoolean;
    }

    @Parameterized.Parameters
    public static Object[][] getTestAccountData() {
        return new Object[][]{
                {"T M", true},
                {"Девятадцать символо", true},
                {"Тимоти Шаламе", true},
                {"Ти", false},
                {"ТимотиТимотиТимотиТи", false},
                {"Тим  Ша", false},
                {" Тим", false},
                {"Тим ", false},
                {"", false},
                {null, false}
        };
    }

    @Test
    public void accountNameTest() {
        Account account = new Account(name);
        boolean actBoolean = account.checkNameToEmboss();
        assertEquals(expBoolean, actBoolean);
    }

}
