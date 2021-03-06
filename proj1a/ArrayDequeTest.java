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
        ArrayDeque<Integer> exam1 = new ArrayDeque();
        exam1.addFirst(0);
        Assert.assertEquals(1, exam1.size());
        Assert.assertEquals(Integer.valueOf(0), exam1.get(0));
    }

    @Test
    public void testAddLast() {
        ArrayDeque<Integer> exam1 = new ArrayDeque();
        exam1.addLast(0);
        Assert.assertEquals(1, exam1.size());
        Assert.assertEquals(Integer.valueOf(0), exam1.get(0));
    }

    @Test
    public void testAddLastMore() {
        ArrayDeque<Integer> exam1 = new ArrayDeque();
        for (int i = 0; i < 8; i++) {
            exam1.addLast(i);
            Assert.assertEquals(i + 1, exam1.size());
            Assert.assertEquals(Integer.valueOf(i), exam1.get(i));
        }
    }

    @Test
    public void resizeThresholdTester() {
        ArrayDeque<Integer> exam1 = new ArrayDeque();
        for (int i = 0; i < 50; i++) {
            exam1.addLast(i);
            Assert.assertEquals(i + 1, exam1.size());
            Assert.assertEquals(Integer.valueOf(i), exam1.get(i));
        }
        Integer first = exam1.removeFirst();
        Assert.assertEquals(Integer.valueOf(0), first);
        for (int i = 49; i > 0; i--) {
            Integer last = exam1.removeLast();
            Assert.assertEquals(Integer.valueOf(i), last);
        }

    }

//    @Test
//    public void arraycopyExperiment() {
//        int[] a = new int[16];
//        for (int i = 0; i < 16; i++) {
//            a[i] = i;
//        }
//        int[] b = new int[16];
//        System.arraycopy(a, 5, b, 0, 16);
//        b[0] = 0;
//    }

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
