import java.util.*;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper or Scissors: ");
            String player = sc.next();

            player = player.substring(0, 1).toUpperCase()
                    + player.substring(1).toLowerCase();

            String computer = moves[random.nextInt(3)];

            String result = playRound(player, computer);

            playerMoves[i] = player;
            computerMoves[i] = computer;
            results[i] = result;

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;

            System.out.println("Computer: " + computer);
            System.out.println("Result: " + result);
            System.out.println();
        }

        System.out.println("----------- FINAL SUMMARY -----------");
        System.out.printf("%-8s %-15s %-15s %-20s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < 5; i++) {
            System.out.printf("%-8d %-15s %-15s %-20s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        sc.close();
    }
}