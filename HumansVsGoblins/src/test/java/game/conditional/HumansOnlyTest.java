package game.conditional;

import java.util.ArrayList;

import interactable.creature.Creature;
import interactable.creature.Goblin;
import interactable.creature.Human;

import static org.junit.jupiter.api.Assertions.*;

class HumansOnlyTest {

    @org.junit.jupiter.api.Test
    void qualified() {
        Goblin goblin1 = new Goblin();
        Goblin goblin2 = new Goblin();
        Goblin goblin3 = new Goblin();
        Human human1 = new Human();
        Human human2 = new Human();
        ArrayList<Creature> creatures = new ArrayList<>();
        creatures.add(goblin1);
        creatures.add(goblin2);
        creatures.add(goblin3);
        creatures.add(human1);
        creatures.add(human2);

        HumansOnly humansOnly = new HumansOnly();
        ArrayList<Integer> indeces = (ArrayList<Integer>) humansOnly.qualified(creatures);

        assertEquals(2, indeces.size());
        assertEquals(creatures.get(indeces.get(0)), human1);
        assertEquals(creatures.get(indeces.get(1)), human2);

    }
}