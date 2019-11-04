public class ArrayDeque<Horse> {

    private Horse[] items;
//    private int size;
    private int firstIndex;
    private int size;
    private final int FACTOR = 2;
    private final double ratio = 0.25;

//  empty deque constructor.
    public ArrayDeque() {

        items = (Horse []) new Object[8];

        firstIndex = 0;
        size = 0;
    }

    // ArrayDeque constructor with x.
    public ArrayDeque(Horse x) {
//        size = 1;

        items = (Horse []) new Object[8];
        items[0] = x;
        firstIndex = 0;
        size = 1;
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

    // Adds an item of type Horse to the front of the deque.
    public void addFirst(Horse x) {
        if (size == items.length) {
            resizing(size * FACTOR);
        }
        firstIndex = minus(firstIndex, 1);
        items[firstIndex] = x;
        size += 1;
    }

    public void addLast(Horse x) {
        if (size() == items.length) {
            resizing(size() * FACTOR);
        }
        int index = plus(firstIndex, size);
        items[index] = x;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        int i = 0;
        while (i < size) {
            int realI = plus(firstIndex, i);
            System.out.print(items[realI] + " ");
            i = i + 1;
        }
        System.out.println();
    }

    public Horse getLast() {
        if (isEmpty()) {
            return null;
        }
        int lastIndex = plus(firstIndex, size - 1);
        return items[lastIndex];
    }

    public void checkUseRatio() {
        Double useRatio = (double) size() / items.length;
        if (useRatio < ratio) {
            int l = (int)Math.ceil(items.length * ratio);
            resizing(l);
        }
    }

    public Horse removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (items.length >= 16) {
            checkUseRatio();
        }
        Horse n = items[firstIndex];

        items[firstIndex] = null;
        firstIndex = plus(firstIndex, 1);
        size -= 1;

        return n;
    }

    public Horse removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (items.length >= 16) {
            checkUseRatio();
        }

        int lastIndex = plus(firstIndex, size - 1);
        Horse n = items[lastIndex];
        items[lastIndex] = null;
        size -= 1;
        return n;
    }

    public Horse get(int i) {
        if (i >= size) {
            return null;
        }
        int realIndex = plus(firstIndex, i);
        return items[i + realIndex];
    }
}
