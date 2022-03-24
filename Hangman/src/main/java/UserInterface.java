import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

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
    public String singleCharPrompt(){ return "Please enter a single character."; }
    public void display(String s) {
        System.out.println(s);
    }
    public String namePrompt(){
        return "Please enter your name.";
    }
    public String success(String answer) { return String.format("Yes! The secret word is %s! You have won!", answer); }
    public String fail(String answer) { return String.format("Sorry! The secret word was %s. Better luck next time.", answer); }
    public String highScoreGrats(String name, int guesses) { return String.format("Congrats %s, you have the high score of only %s guesses!", name, guesses); }

    public String buildGallows(int failedCount){
        FileIO io = new FileIO(); // todo
        Counter displayedCtr = new Counter();

        ArrayList<String> lines = io.getFileLines(FileIO.MAN_PATH);
        ArrayList<ArrayList<String>> linesByChar = lines.stream()
                .map(s -> s.chars()
                        .mapToObj(c -> (char) c)
                        .map(c -> {
                            if (c != ' '){
                                if (displayedCtr.getValue() < failedCount){
                                    displayedCtr.incrementValue();
                                    return String.valueOf(c);
                                }
                                else return " ";
                            }
                            else return " ";

                        })
                        .collect(Collectors.toCollection(ArrayList::new))
                )
                .map(s -> {
                    s.add("    |");
                    return s;
                })
                .collect(Collectors.toCollection(ArrayList::new));

        int gallowsH = linesByChar.size();
        int gallowsW = linesByChar.get(0).size();

        String result = linesByChar.stream()
                .map(inner -> inner.stream().reduce("",(a,b) -> a+b))
                .reduce("", (a,b) -> a+b+'\n');

        result = "+" + "-".repeat(2+gallowsW) + "+\n" +
                result +
                " ".repeat(2+gallowsW) + "===";

        return result;
    }

    public void displayState(HangmanGame game){
        display(buildGallows(game.getWrongGuesses().size()));
        display(missedLetters(game.getWrongGuesses()));
        display(guessedString(game.getAnswer(), game.getCorrectGuesses()));
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
