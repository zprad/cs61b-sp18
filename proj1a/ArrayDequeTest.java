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

//    @Test
//    public void testResizing() {
//        ArrayDeque<String> exam1 = new ArrayDeque();
//        String[] arr1 = {"0", "1", "2", "3", "4", "5", "6", "7"};
//        String[] r1 = exam1.resizing(16, arr1, 0);
//        String[] exp1 = new String[16];
//        for (int i = 0; i < 8; i++) {
//            exp1[i] = String.valueOf(i);
//        }
//        Assert.assertArrayEquals(exp1, r1);
//    }
}
