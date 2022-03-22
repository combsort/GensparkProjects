import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ryan on 9/23/2017.
 */

public class Main {

    public static void displayState(UserInterface ui, HangmanGame game){
        ui.display(ui.buildGallows(game.getWrongGuesses().size()));
        ui.display(ui.missedLetters(game.getWrongGuesses()));
        ui.display(ui.guessedString(game.getAnswer(), game.getCorrectGuesses()));
    }

    public static char getNewGuess(UserInterface ui, HangmanGame game, UserInput input){
            char guess = input.getCharInput();
            if (game.alreadyGuessed(guess)) {
                ui.display(ui.alreadyGuessedPrompt());
                return getNewGuess(ui, game, input);
            }
            else return guess;
    }

    private ArrayList<String> getFileLines(String path){
        File file = new File(path);
        ArrayList<String> contents = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String next = scanner.nextLine();
                contents.add(next);
            }
        } catch (IOException e) {
            System.out.println("Failure opening file: " + e.getMessage());
        }
        return contents;
    }

    public static void runGame(UserInterface ui, HangmanGame game, UserInput input){

        ui.display((ui.title()));
        displayState(ui, game);

        while (!game.gameIsEnded()){

            ui.display(ui.guessPrompt());
            char guess = getNewGuess(ui, game, input);
            game.addGuess(guess);
            displayState(ui, game);

        }

        displayState(ui, game);

        if (game.didWin()) ui.display(ui.success(game.getAnswer()));
        else ui.display(ui.fail(game.getAnswer()));
    }

    public static void gameLoop(UserInterface ui, HangmanGame game, UserInput input){
        ui.display(ui.playAgainPrompt());
        String response = input.getInput();

        if (response.equals(UserInterface.STOP_STR)) return;

        game.reset();
        gameLoop(ui, game, input);
    }

    public static void main(String[] args){
        UserInterface ui = new UserInterface();
        HangmanGame game = new HangmanGame();
        UserInput input = new UserInput(ui);
        gameLoop(ui, game, input);
    }
}
