import java.util.Scanner;

public class Main {

    public static final String INTRO = "You are in a land full of dragons. In front of you, you see two caves. In one cave, the dragon is friendly and will share his treasure with you. The other dragon is greedy and will eat you on sight. Which cave do you go into? (1 or 2)";
    public static final String BAD_END = "You approach the cave and get eaten!";
    public static final String GOOD_END = "You approach the cave and get treasure!";
    public static final String INVALID = "Invalid dragonCave option";
    public static final String VALID_OPTIONS = "Options: 1 or 2";

    public static String dragonCave(int option) throws Exception{
            if (option == 1){
                return GOOD_END;
            }
            else if (option == 2){
                return BAD_END;
            }
            else throw new Exception(INVALID);
    }

    public static int getIntegerOption(Scanner scanner){
        while(true){
            String optionString = scanner.nextLine();
            try{
                int option = Integer.parseInt(optionString);
                return option;
            }
            catch(Exception e){
                System.out.println(VALID_OPTIONS);
                continue;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(INTRO);
        Scanner in = new Scanner(System.in);

        while(true){
            int option = getIntegerOption(in);

            try{
                String response = dragonCave(option);
                System.out.println(response);
                break;
            }catch(Exception e){
                System.out.println(VALID_OPTIONS);
                continue;
            }
        }
    }
}
