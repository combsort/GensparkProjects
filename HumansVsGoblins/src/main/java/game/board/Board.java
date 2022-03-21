package game.board;

import interactable.Interactable;
import interactable.creature.Goblin;
import interactable.creature.Human;
import ui.display.Displayable;

import java.util.ArrayList;

public class Board implements Displayable {

    ArrayList<ArrayList<Tile>> grid;

    public Board(){
        ArrayList<Interactable> tile1Contents = new ArrayList<>();
        tile1Contents.add(new Human());
        ArrayList<Interactable> tile9Contents = new ArrayList<>();
        tile9Contents.add(new Goblin());

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
