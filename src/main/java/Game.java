import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Integer> rolls = new ArrayList<Integer>();
    public void roll(int pinsDown) {
        rolls.add(pinsDown);
    }

    public int score() {
        int score = 0;
        int cursor = 0;

        for (int frame = 0; frame < 10 ; frame++) {
            if (isStrike(cursor)) {
                score += strikeBonus(cursor);
                cursor += 1;
            } else if(isSpare(cursor)) {
                score += spareBonus(cursor);
                cursor += 2;
            } else {
                score += regularRollBonus(cursor);
                cursor += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int cursor) {
        return rolls.get(cursor) == 10;
    }
    private int strikeBonus(int cursor) {
        return 10 + rolls.get(cursor + 1) + rolls.get(cursor + 2);
    }
    private boolean isSpare(int cursor) {
        return rolls.get(cursor) + rolls.get(cursor + 1) == 10;
    }
    private int spareBonus(int cursor) {
        return 10 + rolls.get(cursor + 2);
    }
    private int regularRollBonus(int cursor) {
        return rolls.get(cursor) + rolls.get(cursor + 1);
    }
}
