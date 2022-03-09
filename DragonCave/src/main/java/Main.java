import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("You are in a land full of dragons. In front of you, you see two caves. In one cave, the dragon is friendly and will share his treasure with you. The other dragon is greedy and will eat you on sight. Which cave do you go into? (1 or 2)");

        while(true){
            Scanner in = new Scanner(System.in);

            try{
                String optionString = in.nextLine();
                int option = Integer.parseInt(optionString);
                if (option == 1){
                    System.out.printf("You approach the cave and get eaten!\n");
                }
                else if (option == 2){
                    System.out.printf("You approach the cave and get treasure!\n");
                }
                break;
            }
            catch(Exception e){
                System.out.printf("Options: 1 or 2\n");
            }
        }
    }
}
