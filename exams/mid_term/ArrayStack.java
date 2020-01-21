/**
 * ArrayStack, problem 5
 */
public class ArrayStack<Item> implements Stack<Item> {

    private Item[] items;
    private int size;

    public ArrayStack() {
        items = (Item[]) new Object[8];
        size = 0;
    }

    private void resize(int capacity) {
        Item[] newItems = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public void push(Item x) {
        if (usageRatio() == 1) {
            int c = items.length * 2;
            resize(c);
        }
        items[size] = x;
        size += 1;
    }

    public Item pop() { // returns null if stack is empty
        if (size() == 0) {
            return null;
        }
        if (usageRatio() < 0.25 && items.length > 8) {
            int c = items.length / 2;
            resize(c);
        }
        Item lastItem = items[size - 1];
        size = size - 1;
        return lastItem;
    }

    public int size() {
        return size;
    }

    private double usageRatio() {
        return ((double) size()) / items.length;
    }
}