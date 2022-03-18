import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {

    UserInterface ui;

    @BeforeEach
    void setUp() {
        this.ui = new UserInterface();
    }

    @Test
    void buildGallows() {
        System.out.println(ui.buildGallows(0));
        System.out.println(ui.buildGallows(1));
        System.out.println(ui.buildGallows(2));
        System.out.println(ui.buildGallows(3));
    }

    @Test
    void guessedString() {
        ArrayList<Character> guessed = new ArrayList<Character>();
        Assertions.assertEquals("", ui.guessedString("",guessed));
        guessed.add('a');
        Assertions.assertEquals("_ a _", ui.guessedString("cat",guessed));
        guessed.add('c');
        guessed.add('t');
        Assertions.assertEquals("c a t", ui.guessedString("cat",guessed));
    }
}