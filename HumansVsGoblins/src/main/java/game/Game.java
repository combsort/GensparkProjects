package game;

import game.board.Board;
import game.turn.TurnTracker;
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
        board = new Board();
        turnTracker = new TurnTracker(roster);
        ui = new UserInterface();
        input = new UserInput(ui);
    }

    public void runGame(){
        ui.renderBoard(board);
    }

}
