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
            if (isSpare(cursor)) {
                score += 10 + rolls.get(cursor + 2);
                cursor += 2;
            } else {
                score += rolls.get(cursor) + rolls.get(cursor + 1);
                cursor += 2;
            }
        }

        return score;
    }

    private boolean isSpare(int cursor) {
        return rolls.get(cursor) + rolls.get(cursor + 1) == 10;
    }
}
