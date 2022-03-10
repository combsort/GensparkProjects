import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void getResult() {
        assertEquals(Main.LOW, Main.getResult(1,2));
        assertEquals(Main.HIGH, Main.getResult(15,9));
        assertEquals(Main.CORRECT, Main.getResult(3,3));
    }
}