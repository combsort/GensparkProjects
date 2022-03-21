package ui;

import game.board.Board;
import ui.display.BoardDisplay;
import ui.display.Displayable;

public class UserInterface {

    public static final String QUIT_KEY = "q";
    private BoardDisplay boardDisplay;

    public UserInterface(){
        this.boardDisplay = new BoardDisplay();
    }

    public void renderBoard(Board board){
        System.out.print(boardDisplay.display(board));
    }

    // messages
    public String movementPrompt(){
        return "Enter n/s/e/w to move";
    }
    public String tier1Prompt(){
        return "Options: m to move,  to loot, or q to quit";
    }


    public void displayMessage(String s){
        System.out.println(s);
    }

}
