import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void dragonCave() {
        try{
            assertEquals(Main.GOOD_END, Main.dragonCave(1));
            assertEquals(Main.BAD_END, Main.dragonCave(2));
        }
        catch(Exception e){
            System.out.println(Main.INVALID);
        }
    }
}