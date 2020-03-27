import java.util.Scanner;

public class Prompter {
    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }//end Constructor

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        String guessInput = scanner.nextLine();
        char guess = guessInput.charAt(0); //picks up only one first letter
        boolean isHit = false;
        try {
            isHit = game.applyGuess(guess); //sending guessing letter to class Game
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }//end try catch
        return isHit;
    }//end promptForGuess

    public void displayProgress() {
        System.out.println("You have: " + game.getRemainingTreies() + " to guess. \nTry to solve: " + game.getCurrentProgress());
    }


}//end class Prompter
