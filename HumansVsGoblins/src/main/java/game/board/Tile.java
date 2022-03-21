package game.board;

import interactable.Interactable;
import interactable.creature.Creature;
import ui.display.Displayable;

import java.util.List;

import java.util.ArrayList;

public class Tile implements Holder, Displayable {

    boolean passableTerrain;
    boolean occupied;
    ArrayList<Interactable> contents;


    public Tile(){
        this.passableTerrain = true;
        this.contents = new ArrayList<>();
        this.occupied = calculateOccupied();
    }

    public Tile(boolean passableTerrain){
        this.passableTerrain = passableTerrain;
        this.contents = new ArrayList<>();
        this.occupied = calculateOccupied();
    }

    public Tile(boolean passableTerrain, ArrayList<Interactable> contents){
        this.contents = contents;
        this.occupied = calculateOccupied();
        this.passableTerrain = passableTerrain;
    }

    public Tile(ArrayList<Interactable> contents){
        this.contents = contents;
        this.occupied = calculateOccupied();
        this.passableTerrain = true;
    }

    public List<Interactable> prioritizeContents() {
        return this.contents;
    }

    public List<Interactable> getContents(){
        return this.contents;
    }

    public Creature getFirstOccupant(){
        for (Interactable i : contents){
            if (i instanceof Creature) return (Creature) i;
        }
        return null;
    }

    public void addToContents(Interactable i){
        contents.add(i);
    }

    public boolean isPassableTerrain() {
        return passableTerrain;
    }

    public void setPassableTerrain(boolean passableTerrain) {
        this.passableTerrain = passableTerrain;
    }

    public boolean isPassable(){
        return !occupied && passableTerrain;
    }

    public boolean calculateOccupied(){
        for (Interactable i : contents){
            if (i instanceof Creature){
                this.occupied = true;
                return true;
            }
        }
        this.occupied = false;
        return false;
    }

    public boolean isOccupied(){
        return occupied;
    }
    public void setOccupied(boolean occupied){
        this.occupied = occupied;
    }

}
