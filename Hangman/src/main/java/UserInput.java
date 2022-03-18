import java.util.Scanner;

public class UserInput {

    Scanner scanner;
    UserInterface ui;

    UserInput(UserInterface ui){
        scanner = new Scanner(System.in);
        this.ui = ui;
    }

    public class StringLengthException extends Exception{
        public StringLengthException(String errorMessage) {
            super(errorMessage);
        }
    }

    public char getCharInput(){
        while (true){
            try{
                String input = getInput();
                if (input.length() > 1) throw new StringLengthException("String input too long");
                if (input.length() == 0) throw new StringLengthException("No character provided");
                return input.charAt(0);
            }
            catch(StringLengthException e){
                ui.display(ui.singleCharPrompt());
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
