public class ArrayDeque<Horse> {

    private Horse[] items;
//    private int size;
    private int firstIndex;
    private int lastIndex;
    private final int FACTOR = 2;
    private final double ratio = 0.25;


    public ArrayDeque() {
//        size = 0;

        items = (Horse []) new Object[8];
        // firstIndex和lastIndex等于items.length时，表明Deque为空
        firstIndex = items.length;
        lastIndex = items.length;
    }

    public ArrayDeque(Horse x) {
//        size = 1;

        items = (Horse []) new Object[8];
        items[0] = x;
        firstIndex = 0;
        lastIndex = 0;
    }

    private void resizing(int maxLength) {
        Horse[] newItems = (Horse []) new Object[maxLength];
        System.arraycopy(items, 0, newItems, 0, size());
        items = newItems;
    }

    private int plus(int index, int count) {
        int n = index + count;
        if (n >= items.length) {
            n = n - items.length;
        }
        return n;
    }

    private int minus(int index, int count) {
        int n = index - count;
        if (n < 0) {
            n = n + items.length;
        }
        return n;
    }

    public void addFirst(Horse x) {
        if (size() == items.length) {
            resizing(size() * FACTOR);
        }
        firstIndex = minus(firstIndex, 1);
        items[firstIndex] = x;
    }

    public void addLast(Horse x) {
        if (size() == items.length) {
            resizing(size() * FACTOR);
        }
        lastIndex = plus(lastIndex, 1);
        items[lastIndex] = x;
    }

    public int size() {
        // firstIndex和lastIndex等于items.length时，表明
        if (firstIndex == items.length) {
            return 0;
        }
        return lastIndex - firstIndex + 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void printDeque() {
        int i = firstIndex;
        while (i < lastIndex) {
            System.out.print(items[i] + " ");
            i = i + 1;
        }
        System.out.println();
    }

    public Horse getLast() {
        if (isEmpty()) {
            return null;
        }
        return items[lastIndex - 1];
    }

    public void checkUseRatio() {
        Double useRatio = (double) size() / items.length;
        if (useRatio < ratio) {
            int l = (int)Math.ceil(items.length * ratio);
            resizing(l);
        }
    }

    public Horse removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (items.length >= 16) {
            checkUseRatio();
        }
        Horse n = items[lastIndex];
        items[lastIndex] = null;
        lastIndex = lastIndex - 1;
        return n;
    }

    public Horse get(int i) {
        if (i >= size()) {
            return null;
        }
        return items[i + firstIndex];
    }
}
