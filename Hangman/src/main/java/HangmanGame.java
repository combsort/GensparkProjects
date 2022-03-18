import java.util.HashSet;

public class HangmanGame {

    private HashSet<Character> correctGuesses;
    private HashSet<Character> wrongGuesses;
    private String answer;
    private int limit;

    HangmanGame(){
        this.correctGuesses = new HashSet<>();
        this.wrongGuesses = new HashSet<>();
        this.answer = "cat";
        this.limit = 3;
    }

    HangmanGame(String answer){
        this.correctGuesses = new HashSet<>();
        this.wrongGuesses = new HashSet<>();
        this.answer = answer;
        this.limit = 3;
    }

    HangmanGame(String answer, int limit){
        this.correctGuesses = new HashSet<>();
        this.wrongGuesses = new HashSet<>();
        this.answer = answer;
        this.limit = limit;
    }

    public void reset(){
        this.correctGuesses = new HashSet<>();
        this.wrongGuesses = new HashSet<>();
    }

    public HashSet<Character> getCorrectGuesses() {
        return correctGuesses;
    }
    public HashSet<Character> getWrongGuesses(){
        return wrongGuesses;
    }
    public void addGuess(char c) {
        if (answer.indexOf(c) == -1) wrongGuesses.add(c);
        else correctGuesses.add(c);
    }
    public boolean alreadyGuessed(char c){
        return correctGuesses.contains(c) || wrongGuesses.contains(c);
    }

    public boolean gameIsEnded(){
        if (didWin() || wrongGuesses.size() >= limit) return true;
        else return false;
    }

    public boolean didWin(){
        return correctGuesses.size() == answer.length();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
