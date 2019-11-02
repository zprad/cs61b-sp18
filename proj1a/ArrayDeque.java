public class ArrayDeque<Horse> {

    private Horse[] items;
    private int size;
    private final int FACTOR = 2;
    private final double ratio = 0.25;


    public ArrayDeque() {
        size = 0;
        items = (Horse []) new Object[8];
    }

    public ArrayDeque(Horse x) {
        size = 1;
        items = (Horse []) new Object[8];
        items[0] = x;
    }

    private void resizing(int maxLength) {
        Horse[] newItems = (Horse []) new Object[maxLength];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public void addFirst(Horse x) {

    }

    public void addLast(Horse x) {
        if (size == items.length) {
            resizing(size * FACTOR);
        }
        items[size] = x;
        size += 1;
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
            System.out.print(items[i]);
            System.out.print(" ");
            i = i + 1;
        }
    }

    public Horse getLast() {
        if (isEmpty()) {
            return null;
        }
        return items[size - 1];
    }

    public void checkUseRatio() {
        Double useRatio = (double) size / items.length;
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
        items[size] = null;
        size = size - 1;
        return items[size];
    }

    public Horse get(int i) {
        if (i >= size) {
            return null;
        }
        return items[i];
    }
}
