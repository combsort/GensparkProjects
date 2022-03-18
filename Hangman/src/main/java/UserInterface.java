import java.util.ArrayList;
import java.util.Collection;

public class UserInterface {

    public static final String CONT_STR = "y";
    public static final String STOP_STR = "n";

    public String title(){
        return "H A N G M A N";
    }
    public String missedLetters(Collection<Character> letters){
        StringBuilder sb = new StringBuilder();
        for (Character ch: letters) {
            sb.append(ch);
        }
        return String.format("Missed letters: %s", sb.toString().length() > 0 ? sb.toString() : "(none)");
    }
    public String guessPrompt(){
        return "Guess a letter";
    }
    public String alreadyGuessedPrompt(){
        return "You have already guessed that letter. Choose again.";
    }
    public String playAgainPrompt(){
        return String.format("Do you want to play again? (%s/%s)", CONT_STR, STOP_STR);
    }
    public String success(String answer) { return String.format("Yes! The secret word is %s! You have won!", answer); }
    public String fail(String answer) { return String.format("Sorry! The secret word was %s. Better luck next time.", answer); }
    public String singleCharPrompt(){ return "Please enter a single character."; }
    public void display(String s) {
        System.out.println(s);
    }

    public String buildGallows(int failedCount){
        StringBuilder sb = new StringBuilder();

        String head = failedCount >= 1 ? "O" : " ";
        String body1 = failedCount >= 2 ? "|" : " ";
        String body2 = failedCount >= 3 ? "|" : " ";

        sb.append("+---+\n");
        sb.append(String.format("%s   |\n", head));
        sb.append(String.format("%s   |\n", body1));
        sb.append(String.format("%s   |\n", body2));
        sb.append("   ===\n");

        return sb.toString();
    }

    public String guessedString(String answer, Collection<Character> guessed){
        if (answer.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (int i = 0; i < answer.length(); i++){
            char c = answer.charAt(i);
            sb.append(prefix);
            prefix = " ";
            if (guessed.contains(c)) sb.append(c);
            else sb.append('_');
        }
        return sb.toString();
    }

}
