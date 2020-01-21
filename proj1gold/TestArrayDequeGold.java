import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    // @source StudentArrayDequeLauncher
    @Test
    public void testRandomCall() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                ads1.addLast(i);
            } else {
                sad1.addFirst(i);
                ads1.addFirst(i);
            }
            assertEquals(ads1.size(), sad1.size());



        }

        for (int i = 0; i < 10; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            Integer expect1 = 0;
            Integer actual1 = 0;
            if (numberBetweenZeroAndOne < 0.5) {
                actual1 = sad1.removeLast();
                expect1 = ads1.removeLast();
            } else {
                actual1 = sad1.removeFirst();
                expect1 = ads1.removeFirst();
            }

            assertEquals(expect1, actual1);
        }
    }
}
