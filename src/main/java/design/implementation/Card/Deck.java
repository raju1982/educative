package design.implementation.Card;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        for(int value = 1 ; value <= 13 ; value++){
            for(SUIT suit : SUIT.values()){
                cards.add(new Card(suit, value));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        int cardCount = cards.size();
        Random r = new Random();
        for (int i = 0; i < cardCount ; i++){
            int index = r.nextInt(cardCount-i-1);
            Collections.swap(cards, i, index);
        }
    }
}
