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

            //holds the cards that go to each round's winner
            LinkedList<PlayingCard> winnings = new LinkedList<>();

            rounds++;
            //Normal round
            PlayingCard card1 = player1.pop();
            PlayingCard card2 = player2.pop();
            winnings.add(card1);
            winnings.add(card2);
            System.out.println("Round " + rounds + ": Player 1 plays " + card1.cardName() +
                    ", Player 2 plays " + card2.cardName());

            if (card1.playingCardValue() > card2.playingCardValue()){
                player1.addAll(winnings); //addAll used instead of push() so all cards can be added at once to the end
                System.out.println("Player 1 wins " + winnings.size() + " cards.");
            } else{
                player2.addAll(winnings);
                System.out.println("Player 2 wins " + winnings.size() + " cards.");
            }
            System.out.println("*Player 1: " + player1.size() + " cards. | " +
                    "Player 2: " + player2.size() + " cards.*");
        }
    }
}
