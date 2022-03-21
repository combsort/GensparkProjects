package interactable.creature;

import interactable.Interactable;

public interface Creature extends Interactable {

    int getMoveDistance(char moveDirection);
    void loot();

}
