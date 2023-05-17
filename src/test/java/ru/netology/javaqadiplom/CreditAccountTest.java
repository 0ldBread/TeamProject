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
        Assertions.assertEquals(true,result);
    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        boolean result = account.add(2_000);

        Assertions.assertEquals(3_000, account.getBalance());
        Assertions.assertEquals(true,result);
    }

    @Test
    public void negativeBalanceTopUp() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        boolean result = account.add(4_000);

        Assertions.assertEquals(3_000, account.getBalance());
        Assertions.assertEquals(true,result);
    }

    @Test
    public void topUpOverLimitWithNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        boolean result = account.add(7_000);

        Assertions.assertEquals(-1_000, account.getBalance());
        Assertions.assertEquals(false,result);
    }

    @Test
    public void topUpOverLimitWithZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean result = account.add(6_000);

        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(false,result);
    }

    @Test
    public void topUpOverLimitWithPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        boolean result = account.add(6_000);

        Assertions.assertEquals(1_000, account.getBalance());
        Assertions.assertEquals(false,result);
    }

    @Test
    public void topUpOverLimitAmount() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        boolean result = account.add(1_000);

        Assertions.assertEquals(5_000, account.getBalance());
        Assertions.assertEquals(false,result);
    }

    @Test
    public void buyingFromANegativeBalance() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        boolean result = account.pay(2_000);

        Assertions.assertEquals(-1_000, account.getBalance());
        Assertions.assertEquals(false,result);
    }

    @Test
    public void buyingFromAZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean result = account.pay(1_000);

        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(false,result);
    }

    @Test
    public void buyingFromAPositiveBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        boolean result = account.pay(1_000);

        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(true,result);
    }

    @Test
    public void purchaseOverBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        boolean result = account.pay(4_000);

        Assertions.assertEquals(3_000, account.getBalance());
        Assertions.assertEquals(false,result);
    }

    @Test
    public void negativeBalanceInterestRate() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );
        account.yearChange();
        Assertions.assertEquals(-30, account.getBalance());
    }

    @Test
    public void positiveBalanceInterestRate() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        account.yearChange();
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void zeroBalanceInterestRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.yearChange();
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void checkExceptionForNegativeBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    -1_000,
                    5_000,
                    15
            );
        });
    }

    @Test
    public void checkExceptionForNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    1_000,
                    -5_000,
                    15
            );
        });
    }

    @Test
    public void checkExceptionForNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    1_000,
                    5_000,
                    -15
            );
        });
    }

}
