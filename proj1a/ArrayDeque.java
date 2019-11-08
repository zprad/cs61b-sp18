public class ArrayDeque<T> {

    private T[] items;
//    private int size;
    private int firstIndex;
    private int size;
    private final int FACTOR = 2;
    private final double ratio = 0.25;

//  empty deque constructor.
    public ArrayDeque() {

        items = (T []) new Object[8];

        firstIndex = 0;
        size = 0;
    }

    // ArrayDeque constructor with x.
    /*public ArrayDeque(T x) {
//        size = 1;

        items = (T []) new Object[8];
        items[0] = x;
        firstIndex = 0;
        size = 1;
    }*/

    private void resizing(int maxLength) {
        T[] newItems = (T []) new Object[maxLength];
        int firstPartLength = items.length - firstIndex;
        int restPartLength = firstIndex;
        System.arraycopy(items, firstIndex, newItems, 0, firstPartLength);
        System.arraycopy(items, 0, newItems, firstPartLength, restPartLength);
        items = newItems;
    }

//    public T[] resizing(int maxLength, T[] items, int firstIndex) {
//        T[] newItems = (T []) new Object[maxLength];
//        int firstPartLength = items.length - firstIndex;
//        int restPartLength = firstIndex;
//        System.arraycopy(items, firstIndex, newItems, 0, firstPartLength);
//        System.arraycopy(items, 0, newItems, firstPartLength, restPartLength);
//
//        return newItems;
//    }

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

    // Adds an item of type T to the front of the deque.
    public void addFirst(T x) {
        if (size == items.length) {
            resizing(size * FACTOR);
        }
        firstIndex = minus(firstIndex, 1);
        items[firstIndex] = x;
        size += 1;
    }

    public void addLast(T x) {
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

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        int lastIndex = plus(firstIndex, size - 1);
        return items[lastIndex];
    }

    public void checkUseRatio() {
        Double useRatio = (double) size() / items.length;
        if (useRatio < ratio) {
            int l = (int) Math.ceil(items.length * ratio);
            resizing(l);
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (items.length >= 16) {
            checkUseRatio();
        }
        T n = items[firstIndex];

        items[firstIndex] = null;
        firstIndex = plus(firstIndex, 1);
        size -= 1;

        return n;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (items.length >= 16) {
            checkUseRatio();
        }

        int lastIndex = plus(firstIndex, size - 1);
        T n = items[lastIndex];
        items[lastIndex] = null;
        size -= 1;
        return n;
    }

    public T get(int i) {
        if (i >= size) {
            return null;
        }
        int realIndex = plus(firstIndex, i);
        return items[i + realIndex];
    }
}
