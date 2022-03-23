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
        System.out.println("0\n%s".format(ui.buildGallows(0)));
        System.out.println("1\n%s".format(ui.buildGallows(1)));
        System.out.println("2\n%s".format(ui.buildGallows(2)));
        System.out.println("3\n%s".format(ui.buildGallows(3)));
        System.out.println("4\n%s".format(ui.buildGallows(4)));
        System.out.println("5\n%s".format(ui.buildGallows(5)));
        System.out.println("6\n%s".format(ui.buildGallows(6)));
        System.out.println("7\n%s".format(ui.buildGallows(7)));
        System.out.println("8\n%s".format(ui.buildGallows(8)));
        System.out.println("9\n%s".format(ui.buildGallows(9)));
        System.out.println("10\n%s".format(ui.buildGallows(10)));
        System.out.println("11\n%s".format(ui.buildGallows(11)));
        System.out.println("12\n%s".format(ui.buildGallows(12)));
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