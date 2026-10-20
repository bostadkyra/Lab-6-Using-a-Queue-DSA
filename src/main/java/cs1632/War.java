package cs1632;

import java.util.LinkedList;

public class War {
    PlayingCardDeck deck;
    LinkedList<PlayingCard> player1;
    LinkedList<PlayingCard> player2;
    int rounds;

    public War(){
        deck = new PlayingCardDeck();
        player1 = new LinkedList<>();
        player2 = new LinkedList<>();
        rounds = 0;
    }

    public void playGame(){
        for(int i=0; i < 26; i++) {
            player1.add(deck.nextCard());
            player2.add(deck.nextCard());
        }
        System.out.println("26 cards have been dealt to each player. The game will now begin!\n");
    }
}
