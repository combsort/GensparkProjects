package interactable.creature;

import interactable.Interactable;

public class Goblin extends CreatureConcrete {

    public Goblin() {

    }

    @Override
    public int getMoveDistance(char direction){
        return 1;
    }

    @Override
    public void loot(){

    }

    @Override
    public void interact(){

    }

    @Override
    public char getSymbol(){
        return 'o';
    }

}
