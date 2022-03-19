package game.conditional;

import interactable.creature.Creature;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public interface Conditional {

    List<Integer> qualified(List<Creature> roster);

}
