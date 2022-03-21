package game.board;

import game.Roster;
import interactable.Interactable;
import interactable.creature.Creature;
import interactable.creature.Goblin;
import interactable.creature.Human;
import ui.display.Displayable;

import java.util.ArrayList;
import java.util.HashMap;

public class Board implements Displayable {

    ArrayList<ArrayList<Tile>> grid;
    HashMap<Creature,int[]> locations;

    public Board(Roster roster){
        locations = new HashMap<>();

        Creature creature1 = roster.getCreatures().get(0);
        Creature creature2 = roster.getCreatures().get(1);

        ArrayList<Interactable> tile1Contents = new ArrayList<>();
        tile1Contents.add(creature1);
        locations.put(creature1, new int[] {0,0});

        ArrayList<Interactable> tile9Contents = new ArrayList<>();
        tile9Contents.add(creature2);
        locations.put(creature2, new int[] {2,2});

        ArrayList<Tile> row1 = new ArrayList<>();
        row1.add(new Tile(tile1Contents));
        row1.add(new Tile());
        row1.add(new Tile());
        ArrayList<Tile> row2 = new ArrayList<>();
        row2.add(new Tile());
        row2.add(new Tile(false));
        row2.add(new Tile());
        ArrayList<Tile> row3 = new ArrayList<>();
        row3.add(new Tile());
        row3.add(new Tile());
        row3.add(new Tile(tile9Contents));

        ArrayList<ArrayList<Tile>> newGrid = new ArrayList<>();
        newGrid.add(row1);
        newGrid.add(row2);
        newGrid.add(row3);

        this.grid = newGrid;

    }

    public void move(Creature creature, char direction){
        int[] location = locations.get(creature);
        int srcX = location[0];
        int srcY = location[1];
        Tile srcTile = grid.get(srcY).get(srcX);

        switch (direction) {
            case 'n':

                break;
            case 's':
                Tile dstTile = grid.get(srcY+1).get(srcX);
                locations.put(creature,new int[] {srcX, srcY+1});

                // TODO: "interactable" to creature
                Interactable myGuy = srcTile.getContents().get(0);
                srcTile.getContents().remove(myGuy);
                dstTile.addToContents(myGuy);
                break;

            case 'e':

                break;
            case 'w':

                break;
        }

    }

    public ArrayList<ArrayList<Tile>> getGrid() {
        return grid;
    }

    @Override
    public String toString() {
        return "Board{" +
                "grid=" + grid +
                '}';
    }

}
