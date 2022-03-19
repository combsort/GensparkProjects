package game.turn.logic;

import game.turn.logic.start.HumanStart;
import game.turn.logic.start.Start;

public class SkipGoblinLogic implements TurnLogic{

    private Start start;

    public SkipGoblinLogic(){
        start = new HumanStart();
    }

}
