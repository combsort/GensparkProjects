package game.turn.logic.start.math;

import game.Roster;
import game.turn.logic.start.Start;
import interactable.creature.Creature;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStart implements MathStart, Start {

    public int calculate(List<Creature> creatures){
        return ThreadLocalRandom.current().nextInt(0, creatures.size());
    }

    public Creature start(Roster roster){
        int index = calculate(roster.getCreatures());
        return roster.getCreatures().get(index);
    }
}
