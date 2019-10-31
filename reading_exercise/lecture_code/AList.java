/**
 * AList
 */
public class AList {

    int[] items;
    int size;
    private final int FACTOR = 2;


    public AList() {
        items = new int[100];
        size = 0;
    }

    public AList(int x) {
        items = new int[100];
        items[0] = x;
        size = 1;
    }

    public void resize(int maxLength) {
        int[] newItems = new int[maxLength];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public void addLast(int x) {
        if (size == items.length) {
            resize(size * FACTOR);
        }
        items[size] = x;
        size += 1;
    }

    public int get(int i) {
        return items[i];
    }

    public int getLast() {
        return items[size - 1];
    }

    public void removeLast() {
        items[size] = 0;
        size = size - 1;
    }

    public int size() {
        return size;
    }
}