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
        adjustCurrentFrame();
    }

    private void adjustCurrentFrame() {
        if (firstThrow) {
            firstThrow = false;
        } else {
            firstThrow = true;
            itsCurrentFrame++;
        }
    }

    public int scoreForFrame(int frame) {
        int frameScore = 0;
        int ball = 0;
        for (int currentFrame = 0; currentFrame < frame; currentFrame++) {

            final int firstThrow = itsThrows[ball++];
            final int secondThrow = itsThrows[ball++];

            frameScore += firstThrow + secondThrow;
            // Spare needs next frame's first throw
            if (frameScore == 10) {
                frameScore += itsThrows[ball];
            }
        }
        return frameScore;
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
