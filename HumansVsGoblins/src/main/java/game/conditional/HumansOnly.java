package game.conditional;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import interactable.creature.Creature;
import interactable.creature.Human;

public class HumansOnly implements Conditional{

    public List<Integer> qualified(List<Creature> creatures){
        ArrayList<Integer> qualifiedIndexes = new ArrayList<>();
        for (int i = 0; i < creatures.size(); i++){
            if (creatures.get(i) instanceof Human) qualifiedIndexes.add(i);
        }
        return qualifiedIndexes;
    }

}
