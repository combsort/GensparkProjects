package interactable.creature;

import interactable.Interactable;

public interface Creature extends Interactable {

    void move(int x, int y);
    void loot();

}
