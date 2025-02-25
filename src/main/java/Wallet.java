import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private String owner;
    private final List<String> cards = new ArrayList<String>();
    private final List<Integer> money = new ArrayList<Integer>();
    private final List<Integer> coin = new ArrayList<Integer>();

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void addCard(String card) {
        cards.add(card);
    }

    public List<String> getCards() {
        return cards;
    }

    public boolean takeCard(String card) {
        return cards.remove(card);
    }

    public void addMoney(int money) {
        this.money.add(money);
    }

    public void addCoin(int coin) {
        this.coin.add(coin);
    }

    public Integer countMoney() {
        int total = 0;
        for(Integer m : this.money) {
            total += m;
        }
        for (Integer c : this.coin) {
            total += c;
        }
        return total;
    }

    public int takeMoney(int money) {
        if(money > countMoney()) {
            return 0;
        }

        int amount = money;
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> tempCoin = new ArrayList<Integer>();

        for(Integer m : this.money) {
            if(m <= money) {
                temp.add(m);
                money -= m;
            }
        }
        for(Integer c : this.coin) {
            if(c <= money) {
                tempCoin.add(c);
                money -= c;
            }
        }

        if(money == 0) {
            this.money.removeAll(temp);
            this.coin.removeAll(tempCoin);
            return amount;
        }
        return 0;
    }
}
