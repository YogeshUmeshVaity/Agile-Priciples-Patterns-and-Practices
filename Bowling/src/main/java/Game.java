public class Game {
    private int itsScore = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private boolean firstThrow = true;

    public int score() {
        return scoreForFrame(getCurrentFrame() - 1);
    }

    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (firstThrow) {
            if (pins == 10) {
                itsCurrentFrame++;
            } else {
                firstThrow = false;
            }
        } else {
            firstThrow = true;
            itsCurrentFrame++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame);
    }

    public int scoreForFrame(int frame) {
        int score = 0;
        int frameScore = 0;
        int ball = 0;
        for (int currentFrame = 0; currentFrame < frame; currentFrame++) {
            final int firstThrow = itsThrows[ball++];
            // Check for strike
            if (firstThrow == 10) {
                score += 10 + itsThrows[ball] + itsThrows[ball + 1];
            } else  {
                final int secondThrow = itsThrows[ball++];
                frameScore = firstThrow + secondThrow;
                // Spare needs next frame's first throw
                if (frameScore == 10) {
                    score += frameScore + itsThrows[ball];
                } else {
                    score += frameScore;
                }
            }
        }
        return score;
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
