package game;

import interactable.creature.Creature;
import interactable.creature.CreatureConcrete;

public interface BattleManager {

    void doBattle(Creature c1, Creature c2);

}
