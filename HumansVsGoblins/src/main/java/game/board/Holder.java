package game.board;

import interactable.Interactable;

import java.util.List;

public interface Holder {

    List<Interactable> getContents();
    List<Interactable> prioritizeContents();
}
