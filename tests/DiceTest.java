import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    @Test
    void testDiceListSize() {
        Dice dice=new Dice();
        assertEquals(0,dice.getDiceList().size()); //before rolling dices
        dice.rollDices();
        assertEquals(5,dice.getDiceList().size()); //after rolling dices
        dice.clearDices();
        assertEquals(0,dice.getDiceList().size()); //check if dice array list is cleaned
    }

    @Test
   void testrerollDicesError(){
        Dice dice=new Dice();
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
        Error exception = assertThrows(Error.class, () -> {
            dice.rerollDices(integers);
        });
        String expectedMessage="Invalid Bounds";
        String actualMessage=exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void testrerollDices(){
        Dice dice=new Dice();
        List<Integer> integers = Arrays.asList(1);
        dice.rollDices();
        ArrayList<Integer> dicelistroll=dice.getDiceList();
        int roll=dicelistroll.get(0); //temporary int
        dice.rerollDices(integers);
        ArrayList<Integer> dicelistreroll=dice.getDiceList();
        int rollSecondTime=dicelistreroll.get(0);
        assertNotEquals(roll,rollSecondTime);

    }
}