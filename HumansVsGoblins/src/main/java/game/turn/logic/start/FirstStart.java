package game.turn.logic.start;

import game.Roster;
import interactable.creature.Creature;

public class FirstStart implements Start {

    public Creature start(Roster roster){
        return roster.getCreatures().get(0);
    }

}
