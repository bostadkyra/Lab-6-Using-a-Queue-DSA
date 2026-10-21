package cs1632;

import java.util.LinkedList;
import java.util.Queue;

public class War {
    PlayingCardDeck deck;
    Queue<PlayingCard> player1;
    Queue<PlayingCard> player2;
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
            Queue<PlayingCard> winnings = new LinkedList<>();

            rounds++; //rounds is incremented every time two card values
                        //are drawn and will be compared
            //Normal round
            PlayingCard card1 = player1.poll(); //poll() is like pop() but for Queue types
            PlayingCard card2 = player2.poll();
            winnings.add(card1);
            winnings.add(card2);
            System.out.println("Round " + rounds + ": Player 1 plays " + card1.cardName() +
                    ", Player 2 plays " + card2.cardName());

            boolean gameOverDuringWar = false; //used if one player runs out of cards during War round
            //War repeats if card values are the same again
            while (card1.playingCardValue() == card2.playingCardValue()){
                System.out.println("War!");

                //each player needs at least 3 cards for the winnings pile plus 1 card to play
                boolean player1Short = player1.size() < 4;
                boolean player2Short = player2.size() < 4;

                if(player1Short || player2Short){ // "||" denotes inclusive OR
                    if (player1Short && player2Short){ // && makes sure both variables are checked
                        System.out.println("Both players ran out cards during the war!");
                        result = "It's a tie!";
                    } else if(player1Short) {
                        System.out.println("Player 1 ran out of cards during the war!");
                        result = "Player 2 wins!";
                    } else {
                        System.out.println("Player 2 ran out of cards during the war!");
                        result = "Player 1 wins!";
                    }
                    gameOverDuringWar = true;
                    break;
                }

                //each player takes turns putting 3 cards into the winnings pile
                for (int i=0; i<3; i++){
                    winnings.add(player1.poll());
                    winnings.add(player2.poll());
                }
                System.out.println("Each player puts three cards into the winnings pile.");

                rounds++;
                card1 = player1.poll();
                card2 = player2.poll();
                winnings.add(card1);
                winnings.add(card2);
                System.out.println("War round " + rounds + ": Player 1 plays " + card1.cardName() +
                        ", Player 2 plays " + card2.cardName());
            }

            if (gameOverDuringWar) break; //true if either player runs out of cards during war

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
        //Game Over Results
        System.out.println("\n**********");
        System.out.println("GAME OVER");
        System.out.println(result);
        System.out.println("Rounds of cards played: " + rounds);
        System.out.println("**********");
    }
}
