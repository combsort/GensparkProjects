package game.turn;

import game.Roster;
import game.turn.logic.AlwaysFirst;
import game.turn.logic.PlayersHuman;
import game.turn.logic.TurnLogic;
import interactable.creature.Creature;

public class TurnTracker {

    private TurnLogic turnLogic;
    private Roster roster;
    private Creature activeCreature;

    public TurnTracker(Roster roster){
        turnLogic = new AlwaysFirst(roster);
        this.roster = roster;
        activeCreature = turnLogic.nextTurn();
    }

    public Creature getActiveCreature() {
        return activeCreature;
    }
    public void setActiveCreature(Creature activeCreature) {
        this.activeCreature = activeCreature;
    }

    public Creature nextTurn(){
        Creature active = turnLogic.nextTurn();
        activeCreature = active;
        return active;
    }

}
