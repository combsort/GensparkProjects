package interactable.creature;

import interactable.Interactable;

public interface Creature extends Interactable {

    int getMoveDistance(char moveDirection);
    void loot();
    String getName();
    int attack(Creature c);
    void setHealth(int h);
    int getHealth();

}
