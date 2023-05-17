package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean result = account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
        Assertions.assertEquals(true, result);
    }

    @Test
    public void shouldAddNegativeAmount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        boolean result = account.add(-3_000);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void shouldAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        boolean result = account.add(11_000);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void shouldAddZeroAmount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        boolean result = account.add(0);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void shouldBeInitialBalanceZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5
        );
        boolean result = account.add(0);
        Assertions.assertEquals(0, account.getBalance());
    }


    @Test
    public void minBalanceCouldBeZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.getMinBalance());
    }


    @Test
    public void rateShouldBeZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );
        Assertions.assertEquals(0, account.getRate());
    }


    @Test
    public void minBalanceShouldBeMoreThanMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    11_000,
                    10_000,
                    5
            );
        });

    }

    @Test
    public void initialBalanceShouldNotBeNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    -2_000,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void minBalanceShouldNotBeNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    -1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void maxBalanceShouldNotBeNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    -10_000,
                    5
            );
        });
    }

    @Test
    public void maxBalanceShouldNotBeZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    0,
                    5
            );
        });
    }

    @Test
    public void rateShouldNotBeNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -5);

        });
    }

    @Test
    public void initialBalanceShouldBeLessThanMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    500,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void initialBalanceShouldBeMoreThanMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    50_000,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void shouldPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        boolean result = account.pay(1_000);
        Assertions.assertEquals(1_000, account.getBalance());
        Assertions.assertEquals(true, result);
    }

    @Test
    public void shouldPayNone() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        boolean result = account.pay(0);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void shouldPayMoreThanBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        boolean result = account.pay(3_000);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void amountShouldNotBeNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        boolean result = account.pay(-2_000);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void shouldBalanceBeLessThanMin() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        boolean result = account.pay(1_200);
        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void shouldCalcInterestInBalance() {
        SavingAccount account = new SavingAccount(
                200,
                100,
                12_000,
                15
        );
        account.yearChange();
        Assertions.assertEquals(30, account.yearChange());
    }

}
