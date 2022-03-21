package interactable.creature;

import interactable.Interactable;

public class CreatureConcrete implements Creature {

    Creature creature;

    int strength;
    String stamina;
    String name;
    String color;
    int x;
    int y;
    char symbol;

    public CreatureConcrete(Creature creature){
        this.symbol = creature.getSymbol();
        this.creature = creature;
    }

    @Override
    public void interact() {

    }

    @Override
    public void move(int x, int y) {
        this.creature.move(x, y);
    }

    @Override
    public void loot() {
        this.creature.loot();
    }

    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public String getStamina() {
        return stamina;
    }
    public void setStamina(String stamina) {
        this.stamina = stamina;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public char getSymbol(){
        return this.symbol;
    }


    @Override
    public String toString() {
        return "CreatureConcrete{" +
                "creature=" + creature +
                ", strength=" + strength +
                ", stamina='" + stamina + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
