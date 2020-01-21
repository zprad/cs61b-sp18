/**
 * Combine
 */
public class Combine {

    public static int combine(ComFunc f, int[] x) {
        if (x == null) {
            return 0;
        }
        if (x.length == 1) {
            return x[0];
        }
        return combine_helper(f, x, 1, x[0]);
    }

    private static int combine_helper(ComFunc f, int[] x, int index, int init) {
        if (index < x.length) {
            init = f.apply(x[index], init);
            return combine_helper(f, x, (index + 1), init);
        } else {
            return init;
        }
    }
}


// 6(b) answer: return Combine.combine(new Add(), x);