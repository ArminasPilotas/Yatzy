import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {
    ArrayList<Integer> dices = new ArrayList<Integer>();
    void addDices() {
        dices.add(1);
        dices.add(2);
        dices.add(5);
        dices.add(1);
        dices.add(2);
    }
@Test
    void testIsGameEnded(){
    Game game=new Game(new Dice(),new ScoreBoard());
    addDices();
    ScoreBoard scoreBoard=game.getScoreBoard();
    scoreBoard.calculateScore(dices);
    scoreBoard.updateScore("Fives");
    assertFalse(game.isGameEnded());
    scoreBoard.calculateScore(dices);
    scoreBoard.updateScore("One Pair");
    assertFalse(game.isGameEnded());
    scoreBoard.calculateScore(dices);
    scoreBoard.updateScore("Chance");
    assertTrue(game.isGameEnded());
}
}