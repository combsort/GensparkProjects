package game.turn;

import game.turn.logic.SkipGoblinLogic;
import game.turn.logic.TurnLogic;

public class TurnTracker {

    private TurnLogic turnLogic;

    TurnTracker(){
        turnLogic = new SkipGoblinLogic();
    }

}
