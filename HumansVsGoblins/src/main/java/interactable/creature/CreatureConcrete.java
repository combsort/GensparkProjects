package interactable.creature;

public class CreatureConcrete implements Creature {

    int strength;
    int stamina;
    int health;
    String name;
    String color;

    public CreatureConcrete(){
        this.strength = 2;
        this.stamina = 4;
        this.health = 4;
        this.name = "CreatureConcrete";
        this.color = "grey";
    }

    @Override
    public void interact() {

    }

    @Override
    public int getMoveDistance(char direction){
        return 1;
    }

    public int attack(Creature creature){
        int maxDmg = this.getStrength();
        int minDmg = 0;
        int result = minDmg + (int)(Math.random() * ((maxDmg - minDmg) + 1));
        return result;
    }

    @Override
    public void loot() {

    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
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
