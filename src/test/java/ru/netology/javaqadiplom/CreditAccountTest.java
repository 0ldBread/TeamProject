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

        Assertions.assertTrue(account.add(3_000));
        Assertions.assertEquals(3_000, account.getBalance());
    }

   @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );

        Assertions.assertTrue(account.add(3_000));
        Assertions.assertEquals(5_000, account.getBalance());

    }

    @Test
    public void negativeReplenishment() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        Assertions.assertFalse(account.add(-3_000));

        Assertions.assertEquals(3_000, account.getBalance());
    }
    @Test
    public void replenishmentToZero() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        Assertions.assertFalse(account.add(0));

        Assertions.assertEquals(3_000, account.getBalance());
    }


   @Test
    public void shouldNotPayOverLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        Assertions.assertFalse(account.pay(10_000));

        Assertions.assertEquals(5_000, account.getBalance());
    }
    @Test
    public void shouldPayMoreThanInitialBalance() {
        CreditAccount account = new CreditAccount(
                2_000,
                2_000,
                15
        );

        Assertions.assertTrue(account.pay(3_000));

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test
    public void shouldBeZeroAfterPay() {
        CreditAccount account = new CreditAccount(
                2_000,
                2_000,
                15
        );

        Assertions.assertTrue(account.pay(2_000));

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void buyingFromAPositiveBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        Assertions.assertTrue(account.pay(1_000));
        Assertions.assertEquals(2_000, account.getBalance());

    }

    @Test
    public void purchaseOverBalanceButNotLessThanCreditLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                2_000,
                15
        );

        Assertions.assertTrue(account.pay(2_000));
        Assertions.assertEquals(-1_000, account.getBalance());

    }

    @Test
    public void shouldNotBeZeroAmount() {
        CreditAccount account = new CreditAccount(
                2_000,
                2_000,
                15
        );

        Assertions.assertFalse(account.pay(0));
        Assertions.assertEquals(2_000, account.getBalance());

    }
   @Test
    public void shouldBeNegativeAmount() {
        CreditAccount account = new CreditAccount(
                4_000,
                4_000,
                15
        );

        Assertions.assertFalse(account.pay(-1_000));
        Assertions.assertEquals(4_000, account.getBalance());

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
        Assertions.assertEquals(0, account.yearChange());
    }

   @Test
    public void zeroBalanceInterestRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.yearChange());
    }
    @Test
    public void earlyInterestRate() {
        CreditAccount account = new CreditAccount(
                300,
                100,
                15
        );
        account.pay(340);
        Assertions.assertEquals(6, account.yearChange());
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
