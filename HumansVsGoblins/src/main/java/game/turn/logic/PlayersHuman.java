package game.turn.logic;

import game.Roster;
import game.turn.logic.start.Start;
import game.turn.logic.start.math.RandomStart;
import interactable.creature.Creature;

public class PlayersHuman implements TurnLogic{

    private Start start;
    private Roster roster;

    public PlayersHuman(Roster roster){
        start = new RandomStart();
        this.roster = roster;
    }


}
