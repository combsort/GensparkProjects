package ui;

import java.util.Scanner;

public class UserInput {

    Scanner scanner;
    UserInterface ui;

    public UserInput(UserInterface ui){
        scanner = new Scanner(System.in);
        this.ui = ui;
    }

    public class StringLengthException extends Exception{
        public StringLengthException(String errorMessage) {
            super(errorMessage);
        }
    }

    public char tier1Input(){
        while (true){
            try{
                String input = getInput();

                if (input.length() > 1) throw new StringLengthException("String input too long");
                if (input.length() == 0) throw new StringLengthException("No character provided");
                char c = input.charAt(0);
                if ("mMqQlL".indexOf(c) == -1) throw new Exception("Input does not match options");
                return input.charAt(0);
            }
            catch(Exception e){
                ui.displayMessage(ui.tier1Prompt());
            }
        }
    }

    public char getMoveInput(){
        while (true){
            try{
                String input = getInput();

                if (input.length() > 1) throw new StringLengthException("String input too long");
                if (input.length() == 0) throw new StringLengthException("No character provided");
                char c = input.charAt(0);
                if ("nsewNSEW".indexOf(c) == -1) throw new Exception("Input must specify a cardinal direction");
                return input.charAt(0);
            }
            catch(Exception e){
                ui.displayMessage(ui.movementPrompt());
            }
        }
    }

    public String getInput(){
        while(true){
            try{
                String input = scanner.nextLine();
                return input;
            }
            catch(Exception e){
                System.out.printf(String.format("Input error: %s", e.getMessage()));
                continue;
            }
        }
    }
}
