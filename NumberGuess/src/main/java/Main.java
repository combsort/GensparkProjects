import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    public static final String CORRECT = "Good job!";
    public static final String HIGH = "Too high";
    public static final String LOW = "Too low";

    public static String getResult(int guess, int number){
        if (guess == number) return CORRECT;
        else if (guess > number) return HIGH;
        else return LOW;
    }

    public static int getGuess(Scanner scanner, int max, int min){
        int guess;
        while(true){
            try{
                String guessString = scanner.nextLine();
                guess = Integer.parseInt(guessString);
                if (guess > max || guess < min) throw new Exception();
                return guess;
            }
            catch(Exception e){
                System.out.printf("Please provide a number between %s and %s.\n", min, max);
                continue;
            }
        }
    }

    public static void newGame(Scanner scanner, String name, int min, int max, int allowedGuesses) {
        int guesses = 0;
        int guess;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        System.out.printf("I am thinking of a number between %s and %s. You have %s guesses.\n",
                String.valueOf(min),
                String.valueOf(max),
                String.valueOf(allowedGuesses) );

        while(true){
                guess = getGuess(scanner,max,min);
                guesses++;

                String result = getResult(guess, randomNum);
                System.out.println(result);
                if (result.equals(CORRECT)) {
                    System.out.printf("You guessed my number in %s guesses!", guesses);
                    break;
                }

                // check guess limit
                System.out.printf("%s guesses remain\n", allowedGuesses-guesses );
                if (guesses >= allowedGuesses){
                    System.out.printf("Sorry %s, out of guesses. Only %s guesses allowed!", name, allowedGuesses );
                    break;
                }
        }
    }

    public static void main(String[] args) {
        int min = 1, max = 20, allowedGuesses = 6;
        Scanner in = new Scanner(System.in);
        String name;

        while(true){
            System.out.printf("What is your name?\n");
            try{
                name = in.nextLine();
                if (name.length() == 0) throw new Exception();
                break;
            }
            catch(Exception e){
                continue;
            }
        }

        newGame(in, name, min, max, allowedGuesses);
        System.out.printf("\nPlay again? (y/n)\n");

        do {
            String answer;
            try{
                answer = in.nextLine();
            }
            catch(Exception e){
                throw e;
            }

            if (answer.equals("y")) {
                newGame(in, name, min, max, allowedGuesses);
                System.out.printf("\nPlay again? (y/n)\n");
            }
            else if (answer.equals("n")) {
                System.out.printf("\nBye for now");
                break;
            }
            else{
                System.out.printf("\nPlay again? (y/n)\n");
            }
        } while (true);
    }
}
