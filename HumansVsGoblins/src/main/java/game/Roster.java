package game;

import interactable.creature.Creature;

import java.util.Collection;
import java.util.ArrayList;

public class Roster {

    private ArrayList<Creature> creatures;

    public Roster(){
        creatures = new ArrayList<Creature>();
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public void addCreature(Creature creature) {
        this.creatures.add(creature);
    }
}
