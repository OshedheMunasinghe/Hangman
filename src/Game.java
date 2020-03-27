public class Game {
    public static final int MAX_MISSES = 7;
    private String answer;
    private String hits;
    private String misses;

    public Game(String answer) {
        this.answer = answer;
        hits = "";
        misses = "";
    }//end Constructor

    private char normalizeGuess(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("A letter is required");
        }//end if
        letter = Character.toLowerCase(letter);
        if ((misses.indexOf(letter) != -1) || (hits.indexOf(letter) != -1)) {
            throw new IllegalArgumentException(letter + "has already been guessed");
        }//end if
        return letter;
    }//end normalizeGuess

    public boolean applyGuess(String letters){
        if(letters.length() == 0){
            throw new IllegalArgumentException("No letter found");
        }//end if
        char firstLetter = letters.charAt(0);
        return applyGuess(firstLetter);

    }//end applyGuess

    public boolean applyGuess(char letter) {
        letter = normalizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1; // !-1 is because not go out of the bond
        if (isHit) {
            hits += letter; //char convert to String
        } else {
            misses += letter;
        }//end if else
        return isHit;
    }//end applyGuess

    public String getCurrentProgress() {
        String progress = "";
        for (char letter : answer.toCharArray()) {
            char display = '-'; //convert answer to dash
            if (hits.indexOf(letter) != -1) {
                display = letter;
            }//end if
            progress += display; //when it hits it open some of dash
        }//end for
        return progress; //update the "new" progress
    }//end getCurrentProgress

    public int getRemainingTries() {
        return MAX_MISSES - misses.length();
    }

    public boolean isWon(){
        return getCurrentProgress().indexOf('-') == -1;
    }//end isWon


    public String getAnswer() {
        return answer;
    }
}//end class
