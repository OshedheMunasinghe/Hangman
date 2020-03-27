public class Hangman {
    public static void main(String[] args) {
        Game game = new Game("treehouse");
        Prompter prompter = new Prompter(game);
        prompter.displayProgress();
        boolean isHit = prompter.promptForGuess(); //starting the game!
        while (game.getRemainingTreies() > 0) {
            prompter.displayProgress();
            prompter.promptForGuess();

        }//end while
    }//end main
}//end class
