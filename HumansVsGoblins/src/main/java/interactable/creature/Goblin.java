package interactable.creature;

import interactable.Interactable;

public class Goblin implements Creature, Interactable {
    public void move(){

    }

    public void loot(){

    }

    public void interact(){

    }

    int strength;
    String stamina;
    String name;
    String color;

    // Do not change the constructor for goblin please!
    public Goblin() {
    }
    public Goblin(int strength){
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
}
