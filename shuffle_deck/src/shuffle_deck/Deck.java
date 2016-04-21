/**
* @package shuffle_deck
* @author ZS@ZJU
* @version V1.0
*/
package shuffle_deck;

import java.util.Random;

/**
* @className Deck
* @description TODO
* @author ZS@ZJU
* @date Apr 20, 2016 9:13:51 AM
*/
public class Deck {
    private String[] deck = new String[54];

    public Deck() {
        String[] color = new String[] { "S", "H", "C", "D" };   //spade heart club diamond
        String[] value = new String[] { "-A", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-X", "-J", "-Q", "-K" };
        for (int c = 0; c < 4; c++) {
            for (int i = 0; i < 13; i++) {
                deck[c * 13 + i] = color[c] + value[i];
            }
        }
        deck[52] = "B-J";   //black joker
        deck[53] = "R-J";   //red joker
    }

    public void shuffle() {
        Random r = new Random(System.currentTimeMillis());
        // i是指示未洗牌部分的牌堆底的指针
        for (int i = 54; i >= 2; i--) {
            // 选择要放到牌堆底的牌
            int card = r.nextInt(i);
            // 将其与牌堆底的牌交换
            String tmp = deck[i - 1];
            deck[i - 1] = deck[card];
            deck[card] = tmp;

            // 未洗牌部分的牌堆底向上移一张
        }
    }

    public void printDeck() {
        int i = 1;
        for (String s : deck) {
            System.out.print(s+"  ");
            if ((i++) % 13 == 0)
                System.out.println();
        }
    }

    /**
    * @description TODO
    * @param args 
    * @returnType void
    */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Deck d = new Deck();
        System.out.println("Original deck:");
        d.printDeck();
        
        System.out.println("\n\nShuffle the deck:");
        d.shuffle();
        d.printDeck();
    }

}
