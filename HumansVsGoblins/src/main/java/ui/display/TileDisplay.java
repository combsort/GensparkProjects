package ui.display;

import game.board.Tile;

public class TileDisplay {

    public TileDisplay(){};

    public String display(Tile tile){
        try {
            return ""+tile.prioritizeContents().get(0).getSymbol();
        }
        catch (IndexOutOfBoundsException e){
            // empty tile
            return tile.isPassableTerrain() ? "-" : "#";
        }
    }

}
