package game;

import game.board.Board;
import game.turn.TurnTracker;

public class Game {

    private TurnTracker turnTracker;
    private Board board;
    private Roster roster;

    Game(){
        roster = new Roster();
        board = new Board();
        turnTracker = new TurnTracker(roster);
    }

}
