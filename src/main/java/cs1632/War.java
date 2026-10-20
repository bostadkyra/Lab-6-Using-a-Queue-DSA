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

        String result = null;

        while (result == null){
            if (player1.isEmpty() && player2.isEmpty()){
                result = "It's a tie! Sometimes there are no winners in War...";
                break;
            }
            if (player1.isEmpty()){
                result = "Player 2 wins!";
                break;
            }
            if (player2.isEmpty()){
                result = "Player 1 wins!";
                break;
            }
        }
    }
}
