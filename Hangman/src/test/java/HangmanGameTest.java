import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HangmanGameTest {

    HangmanGame game;

    @BeforeEach
    void setUp(){
        this.game = new HangmanGame("cat",3);
    }

    @Test
    void didWin() {
        game.addGuess('c');
        game.addGuess('a');
        Assertions.assertFalse(game.didWin());
        game.addGuess('t');
        Assertions.assertTrue(game.didWin());
        game.addGuess('o');
        Assertions.assertTrue(game.didWin());
        game.reset();

        game.addGuess('c');
        game.addGuess('t');
        Assertions.assertFalse(game.didWin());
        game.addGuess('o');
        Assertions.assertFalse(game.didWin());

    }

    @Test
    void gameIsEnded(){
        // guess 1
        game.addGuess('o');
        game.addGuess('o');
        game.addGuess('o');
        game.addGuess('o');
        game.addGuess('o');
        Assertions.assertFalse(game.gameIsEnded());
        // guess 2
        game.addGuess('2');
        Assertions.assertFalse(game.gameIsEnded());


        // guess 3 - time to end
        game.addGuess('3');
        Assertions.assertTrue(game.gameIsEnded());
        game.reset();

        game.addGuess('c');
        game.addGuess('a');
        Assertions.assertFalse(game.gameIsEnded());
        game.addGuess('o');
        game.addGuess('2');
        Assertions.assertFalse(game.gameIsEnded());

        game.addGuess('t');
        Assertions.assertTrue(game.gameIsEnded());
    }
}