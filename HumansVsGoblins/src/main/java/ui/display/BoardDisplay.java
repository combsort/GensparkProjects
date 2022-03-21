package ui.display;

import game.board.Board;
import game.board.Tile;

import java.util.ArrayList;

public class BoardDisplay implements Display{


    public BoardDisplay(){
    }

    public String display(Displayable displayable){
        Board board = (Board) displayable;

        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Tile>> grid = board.getGrid();
        TileDisplay td = new TileDisplay();

        for (int y = 0; y < grid.size(); y++){
            ArrayList<Tile> row = grid.get(y);
            for (int x = 0; x < row.size(); x++){
                sb.append(td.display(row.get(x)));
            }
            sb.append('\n');
        }

        return sb.toString();
    }

}
