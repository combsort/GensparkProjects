package game;

import game.board.Board;
import game.turn.TurnTracker;

public class Game {

    private TurnTracker turnTracker;
    private Board board;

    Game(){
        turnTracker = new TurnTracker();
    }

}
