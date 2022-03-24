import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

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

    @Test
    void getHighScore(){
        ArrayList<String> lines = new ArrayList<>(Arrays.asList("high,1","2nd,2","3rd,3"));
        Assertions.assertEquals(1,game.getHighScore(lines,""));
        Assertions.assertEquals(1,game.getHighScore(lines,"high"));
        Assertions.assertEquals(2,game.getHighScore(lines,"2nd"));
        Assertions.assertEquals(3,game.getHighScore(lines,"3rd"));
    }

    @Test
    void alreadyGuessed(){
        game.addGuess('o');
        Assertions.assertTrue(game.alreadyGuessed('o'));
        Assertions.assertFalse(game.alreadyGuessed(' '));
        Assertions.assertFalse(game.alreadyGuessed('f'));
    }
}