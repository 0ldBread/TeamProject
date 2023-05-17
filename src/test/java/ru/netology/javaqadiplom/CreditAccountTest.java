package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean result = account.add(3_000);
        Assertions.assertEquals(3_000, account.getBalance());
        Assertions.assertEquals(true, result);
    }

}
