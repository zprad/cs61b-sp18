import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    @Test
    public void testEqualCharsOffByThree() {
        CharacterComparator offByN = new OffByN(3);

        assertTrue(offByN.equalChars('a', 'd'));
        assertTrue(offByN.equalChars('X', 'U'));
        assertFalse(offByN.equalChars('b', 'd'));
        assertFalse(offByN.equalChars('x', 'D'));
    }

    @Test
    public void testEqualCharsOffByZero() {
        CharacterComparator offByN = new OffByN(0);

        assertTrue(offByN.equalChars('x', 'x'));
        assertTrue(offByN.equalChars('A', 'A'));
        assertFalse(offByN.equalChars('c', 'a'));
        assertFalse(offByN.equalChars('x', 'a'));
    }
}
