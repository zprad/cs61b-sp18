import org.junit.Test;
import static org.junit.Assert.*;

/**
 * DiscArrayTest
 */
public class DiscArrayTest {

    @Test
    public void insertOnZeroTest() {
        int[] arr = { 0, 1, 2, 3, 4 };
        int[] newArr = DiscArray.insert(arr, 9, 0);
        int[] expect = { 9, 0, 1, 2, 3, 4 };
        assertArrayEquals(expect, newArr);
    }

    @Test
    public void insertOnLastTest() {
        int[] arr = { 0, 1, 2, 3, 4 };
        int[] newArr = DiscArray.insert(arr, 9, 10);
        int[] expect = { 0, 1, 2, 3, 4, 9 };
        assertArrayEquals(expect, newArr);
    }

    @Test
    public void insertOnMidTest() {
        int[] arr = { 0, 1, 2, 3, 4 };
        int[] newArr = DiscArray.insert(arr, 9, 3);
        int[] expect = { 0, 1, 2, 9, 3, 4 };
        assertArrayEquals(expect, newArr);
    }

    @Test
    public void reverseTest() {
        int[] arr = { 0, 1, 2, 3, 4 };
        DiscArray.reverse(arr);
        int[] expect = { 4, 3, 2, 1, 0 };
        assertArrayEquals(expect, arr);

        int[] arr1 = { 0 };
        DiscArray.reverse(arr1);
        int[] expect1 = { 0 };
        assertArrayEquals(expect1, arr1);
    }

    @Test
    public void replicateTest() {
        int[] arr = { 3, 2, 1 };
        int[] newArr = DiscArray.replicate(arr);
        int[] expect = { 3, 3, 3, 2, 2, 1 };
        assertArrayEquals(expect, newArr);
    }

    @Test
    public void flattenTest() {
        int[][] a = {{1, 2, 3}, {}, {7, 8}};
        int[] result = DiscArray.flatten(a);
        int[] expect = {1, 2, 3, 7, 8};
        assertArrayEquals(result, expect);
    }


}