import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestGame {
    private Game game;
    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testTwoThrowsNoMark() {
        game.add(3);
        game.add(6);
        assertEquals(9, game.score());
        assertEquals(2, game.getCurrentFrame());
    }

    @Test
    public void testFourThrowsNoMark() {
        game.add(5);
        game.add(4);
        game.add(7);
        game.add(2);
        assertEquals(18, game.score());
        assertEquals(9, game.scoreForFrame(1));
        assertEquals(18, game.scoreForFrame(2));
        assertEquals(3, game.getCurrentFrame());
    }

    @Test
    public void testSimpleSpare() {
        game.add(3);
        game.add(7);
        game.add(3);
        assertEquals(13, game.scoreForFrame(1));
        assertEquals(2, game.getCurrentFrame());
    }

    @Test
    public void testSimpleFrameAfterSpare() {
        game.add(3);
        game.add(7);
        game.add(3);
        game.add(2);
        assertEquals(13, game.scoreForFrame(1));
        assertEquals(18, game.scoreForFrame(2));
        assertEquals(3, game.getCurrentFrame());
        assertEquals(18, game.score());
    }

}
