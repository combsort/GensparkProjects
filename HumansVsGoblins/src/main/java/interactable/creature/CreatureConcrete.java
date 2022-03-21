package interactable.creature;

public class CreatureConcrete implements Creature {

    int strength;
    String stamina;
    String name;
    String color;

    public CreatureConcrete(){
    }

    @Override
    public void interact() {

    }

    @Override
    public int getMoveDistance(char direction){
        return 1;
    }

    @Override
    public void loot() {

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
        return '?';
    }


    @Override
    public String toString() {
        return "CreatureConcrete{" +
                "strength=" + strength + '\'' +
                ", stamina='" + stamina + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
