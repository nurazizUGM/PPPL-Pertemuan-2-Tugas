import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    void testOwner() {
        Wallet wallet = new Wallet();
        wallet.setOwner("Nur Aziz");
        assertEquals("Nur Aziz", wallet.getOwner());
    }

    @Test
    void testAddCard() {
        Wallet wallet = new Wallet();
        wallet.addCard("Mandiri");
        wallet.addCard("BNI");
        assertEquals(2, wallet.getCards().size());
    }

    @Test
    void testTakeCard() {
        Wallet wallet = new Wallet();
        wallet.addCard("Mandiri");
        wallet.addCard("BNI");

        wallet.takeCard("Mandiri");
        assertEquals(1, wallet.getCards().size(), "Mandiri Card is not removed");

        wallet.takeCard("BNI");
        assertEquals(0, wallet.getCards().size(), "Mandiri Card is not removed");

        assertFalse(wallet.takeCard("BNI"), "Wallet should not have BNI card");
    }

    @Test
    void testAddMoney() {
        Wallet wallet = new Wallet();
        wallet.addMoney(1000);
        wallet.addCoin(500);
        assertEquals(1500, wallet.countMoney(), "Wallet should have 1500");
    }

    @Test
    void testTakeMoney() {
        Wallet wallet = new Wallet();
        wallet.addMoney(1000);
        wallet.addCoin(500);
        assertEquals(1500, wallet.countMoney(), "Wallet should have 1500");

        assertEquals(0, wallet.takeMoney(2000), "Wallet sould not have 2000");
        assertEquals(1500, wallet.takeMoney(1500), "Wallet should have 1500");
        assertEquals(0, wallet.countMoney(), "Wallet should have 0");
    }

    @Test
    void testTakeMoneyOdd() {
        Wallet wallet = new Wallet();
        wallet.addMoney(5000);
        wallet.addMoney(5000);
        wallet.addCoin(2000);
        wallet.addCoin(2000);
        wallet.addCoin(2000);

        assertEquals(16000, wallet.countMoney(), "Wallet should have 11000");
        assertEquals(11000, wallet.takeMoney(11000), "Wallet should have 11000");
        assertEquals(0, wallet.countMoney(), "Wallet should have 0");
    }
}