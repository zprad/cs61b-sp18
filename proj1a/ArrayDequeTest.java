/** Performs some basic array list tests. */
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;
public class ArrayDequeTest {

    @Test
    public void testEmptyConstructor() {
        ArrayDeque<String> exam1 = new ArrayDeque();
        Assert.assertEquals(0, exam1.size());
    }

    @Test
    public void testAddFirst() {
        ArrayDeque<String> exam1 = new ArrayDeque();
        exam1.addFirst("first");
        Assert.assertEquals(1, exam1.size());
        Assert.assertEquals("first", exam1.get(0));
    }
}
