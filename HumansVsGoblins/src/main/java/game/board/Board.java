package game.board;

import game.Roster;
import interactable.Interactable;
import interactable.creature.Creature;
import ui.display.Displayable;

import java.util.ArrayList;
import java.util.HashMap;

public class Board implements Displayable {

    ArrayList<ArrayList<Tile>> grid;
    HashMap<Interactable, int[]> locations;

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

    public class InvalidDestException extends Exception{
        public InvalidDestException(String errorMessage) {
            super(errorMessage);
        }
    }

    private Tile getDestTile(int dstY, int dstX) throws InvalidDestException{
        try {
            Tile dstTile = grid.get(dstY).get(dstX);
            if (!dstTile.isPassable()) throw new InvalidDestException("Impassable tile");
            return dstTile;
        }
        catch (IndexOutOfBoundsException e){
            throw new InvalidDestException("Out of bounds");
        }
    }

    private void changeInteractableLocation(Tile srcTile, Tile dstTile, int dstY, int dstX){
        Interactable i = srcTile.getContents().get(0); // todo: Get the correct interactable
        srcTile.getContents().remove(i);
        dstTile.addToContents(i);

        locations.put(i, new int[] {dstY, dstX});
    }

    public void move(Creature creature, char direction) throws InvalidDestException{
        int[] location = locations.get(creature);
        int srcY = location[0];
        int srcX = location[1];
        Tile srcTile = grid.get(srcY).get(srcX);
        Tile dstTile;
        int distance = creature.getMoveDistance(direction);

        switch (direction) {
            case 'n':
                dstTile = getDestTile(srcY-distance, srcX);
                changeInteractableLocation(srcTile,dstTile,srcY-distance,srcX);
                break;
            case 's':
                dstTile = getDestTile(srcY+distance, srcX);
                changeInteractableLocation(srcTile,dstTile,srcY+distance,srcX);
                break;

            case 'e':
                dstTile = getDestTile(srcY, srcX+distance);
                changeInteractableLocation(srcTile,dstTile,srcY,srcX+distance);
                break;
            case 'w':
                dstTile = getDestTile(srcY, srcX-distance);
                changeInteractableLocation(srcTile,dstTile,srcY,srcX-distance);
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
