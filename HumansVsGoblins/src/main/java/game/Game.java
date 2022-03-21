package game;

import game.board.Board;
import game.turn.TurnTracker;
import interactable.creature.Creature;
import interactable.creature.CreatureConcrete;
import interactable.creature.Goblin;
import interactable.creature.Human;
import ui.UserInput;
import ui.UserInterface;

public class Game implements BattleManager{

    private TurnTracker turnTracker;
    private Board board;
    private Roster roster;
    private UserInterface ui;
    private UserInput input;

    public Game(){
        roster = new Roster();

        roster.addCreature(new Human());
        roster.addCreature(new Goblin());

        board = new Board(roster, this);
        turnTracker = new TurnTracker(roster);
        ui = new UserInterface();
        input = new UserInput(ui);
    }

    public void doBattle(Creature c1, Creature c2){
        int dmg = c1.attack(c2);
        c2.setHealth(c2.getHealth()-dmg);
        ui.displayMessage(ui.battleResultMsg(c1,c2,dmg));

        if (c2.getHealth() <= 0){
            ui.displayMessage(ui.creatureDeathMsg(c2));
            board.clearCreature(c2);
        }

    }

    private char handleMovement(){
        while (true){
            ui.displayMessage(ui.movementPrompt());
            char direction = input.getMoveInput();
            try {
                board.move(turnTracker.getActiveCreature(), direction);
                return direction;
            }
            catch(Board.InvalidDestException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private char tier1Options(){
        ui.displayMessage(ui.tier1Prompt());
        switch (input.tier1Input()) {
            case 'm':
            case 'M':
                handleMovement();
                return 'm';

            case 'l':
            case 'L':

                return 'l';

            case 'q':
            case 'Q':
                return 'q';
        }

        return 'q';
    }

    public void runGame(){
        do {
            ui.renderBoard(board);
            if (tier1Options() == 'q') break;
            turnTracker.nextTurn();
        }while(true);
    }

}
