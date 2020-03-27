import java.util.Scanner;

public class Prompter {
    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }//end Constructor

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAcceptable = false;


        System.out.print("Enter a letter: ");
        String guessInput = scanner.nextLine();

        do {
            try {
                isHit = game.applyGuess(guessInput); //sending guessing letter to class Game
                isAcceptable = true;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }//end try catch
        }while (!isAcceptable);
        return isHit;
    }//end promptForGuess

    public void displayProgress() {
        System.out.println("You have: " + game.getRemainingTries() + " to guess. \nTry to solve: " + game.getCurrentProgress());
    }


    public void displayoOutCome() {
        if(game.isWon()){
            System.out.println("Congratualtion you won with " + game.getRemainingTries() + " tries remaining.");
        }else {
            System.out.println("Bummer the word was " + game.getAnswer());
        }
    }
}//end class Prompter
