package game.turn.logic;

import game.Roster;
import game.turn.logic.start.FirstStart;
import game.turn.logic.start.Start;
import game.turn.logic.start.math.RandomStart;
import interactable.creature.Creature;

public class AlwaysFirst implements TurnLogic{

    private Start start;
    private Roster roster;

    public AlwaysFirst(Roster roster){
        start = new FirstStart();
        this.roster = roster;
    }

    public Creature nextTurn(){
        return roster.getCreatures().get(0);
    }


}
