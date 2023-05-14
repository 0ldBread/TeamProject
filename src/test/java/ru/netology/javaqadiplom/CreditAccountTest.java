package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }
//    @Test
//    public void shouldAddNone(){
//        CreditAccount account = new CreditAccount(
//                0,
//                5_000,
//                15
//        );
//        account.add(0);
//        Assertions.assertEquals(0,account.getBalance());
//    }
//    @Test
//    public void shouldAddToNegativeBalance(){
//        CreditAccount account = new CreditAccount(
//                0,
//                5_000,
//                15
//        );
//        account.add(-3_000);
//        Assertions.assertEquals(0,account.getBalance());
//    }
//    @Test
//    public void shouldPayAboveCreditLimit(){
//        CreditAccount account = new CreditAccount(
//                0,
//                5_000,
//                15
//        );
//        account.pay(6_000);
//        Assertions.assertEquals(0, account.getBalance());
//    }
//    @Test
//    public void shouldPayWithinCreditLimit(){
//        CreditAccount account = new CreditAccount(
//                0,
//                5_000,
//                15
//        );
//        account.pay(3_000);
//        Assertions.assertEquals(-3_000, account.getBalance());
//    }
//    @Test
//    public void test2() {
//        CreditAccount account = new CreditAccount(
//                0,
//                5_000,
//                15
//        );
//        account.();
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            account.();
//        });
//    }

}
