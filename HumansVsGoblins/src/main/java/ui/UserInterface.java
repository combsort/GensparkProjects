package ui;

import game.board.Board;
import interactable.creature.Creature;
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
        return "Options: m to move, l to loot, or q to quit";
    }
    public String battleResultMsg(Creature c1, Creature c2, int dmg) {
        return String.format("%s strikes %s for %s damage",
                c1.getName(),
                c2.getName(),
                dmg);
    }
    public String creatureDeathMsg(Creature c){
        return String.format("%s has died.", c.getName());
    }


    public void displayMessage(String s){
        System.out.println(s);
    }

}
