import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {
    ArrayList<Integer> dices = new ArrayList<Integer>();
    void addDices() {
        dices.add(1);
        dices.add(2);
        dices.add(5);
        dices.add(1);
        dices.add(2);
    }
    @Test
    void testScoreboardSizes(){
        ScoreBoard scoreBoard=new ScoreBoard();
        assertEquals(3,scoreBoard.getSelectedCategoriesList().size()); //3 categories Fives, Chance, One Pair
        assertEquals(3,scoreBoard.getSelectedCategoriesList().size());

    }
    @Test
    void testCalculateScore(){
        ScoreBoard scoreBoard=new ScoreBoard();
        addDices();
        scoreBoard.calculateScore(dices);
        assertEquals(5,scoreBoard.getCategoriesScoreList().get("Fives"));
        assertEquals(2,scoreBoard.getCategoriesScoreList().get("One Pair"));
        assertEquals(11,scoreBoard.getCategoriesScoreList().get("Chance"));
    }
    @Test
    void testResetCategoriesListScore(){
        ScoreBoard scoreBoard=new ScoreBoard();
        addDices();
        scoreBoard.resetCategoriesListScore();
        for(Map.Entry<String,Integer> entry: scoreBoard.getCategoriesScoreList().entrySet()) {
            assertEquals(0,entry.getValue());
        }
    }
    @Test
    void testUpdateScore(){
        ScoreBoard scoreBoard=new ScoreBoard();
        addDices();
        scoreBoard.calculateScore(dices);
        scoreBoard.updateScore("Chance");
        assertEquals(11,scoreBoard.getSelectedCategoriesList().get("Chance"));
        scoreBoard.calculateScore(dices);
        scoreBoard.updateScore("Fives");
        assertEquals(5,scoreBoard.getSelectedCategoriesList().get("Fives"));
        scoreBoard.calculateScore(dices);
        scoreBoard.updateScore("One Pair");
        assertEquals(2,scoreBoard.getSelectedCategoriesList().get("One Pair"));
    }
    @Test
    void testUpdateScoreError(){
        ScoreBoard scoreBoard=new ScoreBoard();
        addDices();
        scoreBoard.calculateScore(dices);
        Error exception = assertThrows(Error.class, () -> {
            scoreBoard.updateScore("Some String");
        });
        String expectedMessage="Can't find combination";
        String actualMessage=exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}