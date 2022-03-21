package interactable.creature;

import interactable.Interactable;

public class Human extends CreatureConcrete {

    public Human(){
        super();
        this.name = "Human";
    }

    @Override
    public int getMoveDistance(char direction){
        return 1;
    }

    @Override
    public void loot() {

    }

    @Override
    public void interact() {

    }

    @Override
    public char getSymbol(){
        return '@';
    }

}
