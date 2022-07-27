import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingKataTest {
    private Game game;
    @BeforeEach
    public void setUp() {
        game = new Game();
    }
    @Test void allZeroesScoresZero() {
        rollMany(20, 0);

        assertEquals(0, game.score());
    }

    @Test void allOnesScoresTwenty() {
        rollMany(20, 1);

        assertEquals(20, game.score());
    }

    @Test void sparePlusThreeScoresSixteen() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(17, 0);

        assertEquals(16, game.score());
    }

    private void rollMany(int times, int pinsDown) {
        for (int i = 0; i < times; i++) {
            game.roll(pinsDown);
        }
    }
}