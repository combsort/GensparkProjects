import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    public static void newGame(Scanner scanner, String name, int min, int max, int allowedGuesses) {
        int guesses = 0;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        System.out.println(String.format("I am thinking of a number between %s and %s. You have %s guesses.",
                String.valueOf(min),
                String.valueOf(max),
                String.valueOf(allowedGuesses)) );

        while(true){
            if (scanner.hasNextInt()) {
                guesses++;
                int guess = scanner.nextInt();
                if (guess == randomNum){
                    System.out.printf(String.format("Good job %s, you guessed my number in %s guesses!", name, guesses ));
                    break;
                }
                else if (guess > randomNum) System.out.printf("Too high");
                else if (guess < randomNum) System.out.printf("Too low");
                System.out.printf(String.format("; %s guesses remain\n", allowedGuesses-guesses ));

                if (guesses >= allowedGuesses){
                    System.out.printf(String.format("Sorry %s, out of guesses. Only %s guesses allowed!", name, allowedGuesses ));
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int min = 1, max = 20, allowedGuesses = 6;
        Scanner in = new Scanner(System.in);

        System.out.println("What is your name?");
        try{
            String name = in.nextLine();
        }
        catch(){

        }

        newGame(in, name, min, max, allowedGuesses);
        System.out.printf("\nPlay again? (y/n)\n");

        do {
            String answer = in.nextLine();
            if (answer.equals("y")) {
                newGame(in, name, min, max, allowedGuesses);
                System.out.printf("\nPlay again? (y/n)\n");
            }
            else if (answer.equals("n")) {
                System.out.printf("\nBye for now");
                break;
            }
        } while (true);
    }
}
