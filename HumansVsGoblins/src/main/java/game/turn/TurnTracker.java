package game.turn;

import game.Roster;
import game.turn.logic.PlayersHuman;
import game.turn.logic.TurnLogic;
import interactable.creature.Creature;

public class TurnTracker {

    private TurnLogic turnLogic;
    private Roster roster;
    private Creature activeCreature;

    public TurnTracker(Roster roster){
        turnLogic = new PlayersHuman(roster);
        this.roster = roster;
    }

}
