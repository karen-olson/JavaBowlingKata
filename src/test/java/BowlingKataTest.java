import BowlingGame.Game;
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
        rollMany(0, 0,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0);

        assertEquals(0, game.score());
    }

    @Test void allOnesScoresTwenty() {
        rollMany(1, 1,  1, 1,  1, 1,  1, 1,  1, 1,  1, 1,  1, 1,  1, 1,  1, 1,  1, 1);

        assertEquals(20, game.score());
    }

    @Test void sparePlusThreeScoresSixteen() {
        rollMany(5, 5,  3, 0,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0);

        assertEquals(16, game.score());
    }

    @Test void strikePlusThreePlusThreeScoresTwentyFour() {
        rollMany(10, 3, 3,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0,  0, 0);

        assertEquals(22, game.score());
    }

    @Test void rollTwelveStrikes() {
        rollMany(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);

        assertEquals(300, game.score());
    }

    public void rollMany(int...rolls) {
        for (int pinsDown : rolls) {
            game.roll(pinsDown);
        }
    }

}
