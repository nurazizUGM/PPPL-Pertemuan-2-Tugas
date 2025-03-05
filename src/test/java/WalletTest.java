import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    static Wallet wallet;

    @BeforeAll
    static void init() {
        wallet = new Wallet();
    }

    @BeforeEach
    void setUp() {
        wallet.addCard("Jago");

        wallet.addMoney(100000);
        wallet.addMoney(50000);

        wallet.addCoin(1000);
        wallet.addCoin(500);
    }

    @AfterEach
    void clear() {
        wallet.clear();
    }

    @AfterAll
    static void done() {
        wallet = null;
        System.out.println("Wallet is destroyed");
    }

    @Test
    void testOwner() {
        wallet.setOwner("Nur Aziz");
        assertEquals("Nur Aziz", wallet.getOwner());
    }

    @Test
    void testAddCard() {
        wallet.addCard("Mandiri");
        wallet.addCard("BNI");
        assertEquals(3, wallet.getCards().size());
    }

    @Test
    void testTakeCard() {
        wallet.addCard("Mandiri");
        wallet.addCard("BNI");

        wallet.takeCard("Mandiri");
        assertEquals(2, wallet.getCards().size(), "Mandiri Card is not removed");

        wallet.takeCard("BNI");
        assertEquals(1, wallet.getCards().size(), "Mandiri Card is not removed");

        assertFalse(wallet.takeCard("BNI"), "Wallet should not have BNI card");
    }

    @Test
    void testAddMoney() {
        wallet.addMoney(1000);
        wallet.addCoin(500);
        assertEquals(153000, wallet.countMoney(), "Wallet should have 153000");
    }

    @Test
    void testTakeMoney() {
        wallet.addMoney(1000);
        wallet.addCoin(500);
        assertEquals(153000, wallet.countMoney(), "Wallet should have 153000");

        assertEquals(1500, wallet.takeMoney(1500), "Wallet should have 1500");
        assertEquals(151500, wallet.countMoney(), "Wallet should have 151500");
    }

    @Test
    void testTakeMoneyOdd() {
        wallet.addMoney(5000);
        wallet.addMoney(5000);
        wallet.addCoin(2000);
        wallet.addCoin(2000);
        wallet.addCoin(2000);

        assertEquals(167500, wallet.countMoney(), "Wallet should have 11000");
    }
}