import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ryan on 9/23/2017.
 */

public class Main {
    public static void main(String[] args){
        UserInterface ui = new UserInterface();
        HangmanGame game = new HangmanGame();
        UserInput input = new UserInput(ui);
        game.gameLoop(ui, input);
    }
}
