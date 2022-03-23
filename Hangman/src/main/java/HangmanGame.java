import java.util.HashSet;
import java.util.ArrayList;

public class HangmanGame {

    private HashSet<Character> correctGuesses;
    private HashSet<Character> wrongGuesses;
    private String answer;
    private String name;
    private int limit;
    private FileIO io;

    HangmanGame(){
        this.correctGuesses = new HashSet<>();
        this.wrongGuesses = new HashSet<>();
        this.answer = "cat";
        this.limit = 3;
        this.io = new FileIO();
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
    public char getNewGuess(UserInterface ui, UserInput input){
        char guess = input.getCharInput();
        if (alreadyGuessed(guess)) {
            ui.display(ui.alreadyGuessedPrompt());
            return getNewGuess(ui, input);
        }
        else return guess;
    }
    public void recordScore(){
        io.appendLineToFile(FileIO.SCORE_PATH, String.format("%s,%s", name, totalGuesses()));
    }

    public int getHighScore(String name){
        ArrayList<String> lines = io.getFileLines(FileIO.SCORE_PATH);
        int[] results = lines.stream()
                .map(s -> s.split(",",2))
                .filter(s -> s[0].equals(name) || name.equals(""))
                .mapToInt(s -> Integer.parseInt(s[1]))
                .sorted().toArray();

        return (results.length > 0) && (results[0] > 0) ? results[0] : -1;
    }

    public void runGame(UserInterface ui, UserInput input){

        ui.display((ui.title()));
        ui.display(ui.namePrompt());
        this.name = input.getInput();
        ui.displayState(this);

        while (!gameIsEnded()){
            ui.display(ui.guessPrompt());
            char guess = getNewGuess(ui, input);
            addGuess(guess);
            ui.displayState(this);

        }

        ui.displayState(this);

        if (didWin()) ui.display(ui.success(getAnswer()));
        else ui.display(ui.fail(getAnswer()));

        recordScore();
        int highScore = getHighScore("");
        if ( highScore == getHighScore(this.name) ) ui.display(ui.highScoreGrats(this.name,highScore));
    }

    public void gameLoop(UserInterface ui, UserInput input){
        runGame(ui, input);

        ui.display(ui.playAgainPrompt());
        String response = input.getInput();

        if (response.equals(UserInterface.STOP_STR)) return;

        reset();
        gameLoop(ui, input);

    }

    public HashSet<Character> getCorrectGuesses() {
        return correctGuesses;
    }
    public HashSet<Character> getWrongGuesses(){
        return wrongGuesses;
    }
    public int totalGuesses(){
        return getWrongGuesses().size() + getCorrectGuesses().size();
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
