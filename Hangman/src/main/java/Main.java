/**
 * Created by Ryan on 9/23/2017.
 */

public class Main {

    public static void displayState(UserInterface ui, HangmanGame game){
        ui.display(ui.buildGallows(game.getWrongGuesses().size()));
        ui.display(ui.missedLetters(game.getWrongGuesses()));
        ui.display(ui.guessedString(game.getAnswer(), game.getCorrectGuesses()));
    }

    public static void runGame(UserInterface ui, HangmanGame game, UserInput input){
        ui.display((ui.title()));

        while (!game.gameIsEnded()){

            ui.display(ui.guessPrompt());
            char guess;
            while (true){
                guess = input.getCharInput();
                if (game.alreadyGuessed(guess)) ui.display(ui.alreadyGuessedPrompt());
                else break;
            }
            game.addGuess(guess);

        }

        displayState(ui, game);
        if (game.didWin()) ui.display(ui.success(game.getAnswer()));
        else ui.display(ui.fail(game.getAnswer()));
    }

    public static void gameLoop(UserInterface ui, HangmanGame game, UserInput input){
        while (true){
            runGame(ui, game, input);
            ui.display(ui.playAgainPrompt());
            String response = input.getInput();
            if (response.equals(UserInterface.STOP_STR)) break;
            game.reset();
        }
    }

    public static void main(String[] args){
        UserInterface ui = new UserInterface();
        HangmanGame game = new HangmanGame();
        UserInput input = new UserInput(ui);
        gameLoop(ui, game, input);
    }
}
