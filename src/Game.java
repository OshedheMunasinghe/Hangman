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

    public boolean applyGuess(char letter) {
        if((misses.indexOf(letter) -1) || (hits.indexOf(letter) != -1)){ //todo: detta måste fixas senare om jag har fått hjälp
            throw new IllegalArgumentException(letter + "has already been guessed");
        }//end if
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
            if (hits.indexOf(letter) != -1){
            display = letter;
            }//end if
            progress += display; //when it hits it open some of dash
        }//end for
        return progress; //update the "new" progress
    }//end getCurrentProgress

    public int getRemainingTreies(){
        return MAX_MISSES - misses.length();
    }
}//end class
