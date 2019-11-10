import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        char x = 'a';
        char y = 'b';
        char z = 'a';
        assertTrue(offByOne.equalChars(x, y));
        assertTrue(offByOne.equalChars(y, x));
        assertFalse(offByOne.equalChars(x, z));
        assertFalse(offByOne.equalChars('x', 'a'));
    }
}
