import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ryan on 9/23/2017.
 */

public class Main {

    UserInterface ui;
    HangmanGame game;
    UserInput input;







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
        game.gameLoop(ui, input);
    }
}
