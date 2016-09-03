import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestFrame {

    @Test
    public void testScoreNoThrows() {
        Frame frame = new Frame();
        assertEquals(0, frame.getScore());
    }

    @Test
    public void testAddOneThrow() {
        Frame frame = new Frame();
        frame.add(7);
        assertEquals(7, frame.getScore());
    }


}
