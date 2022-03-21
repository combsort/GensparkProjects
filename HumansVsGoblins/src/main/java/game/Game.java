package game;

import game.board.Board;
import game.turn.TurnTracker;
import interactable.creature.Goblin;
import interactable.creature.Human;
import ui.UserInput;
import ui.UserInterface;

public class Game {

    private TurnTracker turnTracker;
    private Board board;
    private Roster roster;
    private UserInterface ui;
    private UserInput input;

    public Game(){
        roster = new Roster();

        roster.addCreature(new Human());
        roster.addCreature(new Goblin());

        board = new Board(roster);
        turnTracker = new TurnTracker(roster);
        ui = new UserInterface();
        input = new UserInput(ui);
    }

    private char handleMovement(){
        ui.displayMessage(ui.movementPrompt());
        char direction = input.getMoveInput();
        board.move(turnTracker.getActiveCreature(), direction);
        return direction;
    }

    private char tier1Options(){
        ui.displayMessage(ui.tier1Prompt());
        switch (input.tier1Input()) {
            case 'm':
            case 'M':
                handleMovement();
                return 'm';

            case 'l':
            case 'L':

                return 'l';

            case 'q':
            case 'Q':
                return 'q';
        }

        return 'q';
    }

    public void runGame(){
        do {
            ui.renderBoard(board);
            if (tier1Options() == 'q') break;

        }while(true);
    }

}
