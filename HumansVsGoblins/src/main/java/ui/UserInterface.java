package ui;

import game.board.Board;
import ui.display.BoardDisplay;
import ui.display.Displayable;

public class UserInterface {

    private BoardDisplay boardDisplay;

    public UserInterface(){
        this.boardDisplay = new BoardDisplay();
    }

    public void renderBoard(Board board){
        System.out.print(boardDisplay.display(board));
    }
}
