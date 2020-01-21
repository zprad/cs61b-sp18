/**
 * Stack
 */
public interface Stack<Item> {

    void push(Item x);

    Item pop();

    int size();

    public default void purge(Item x) {
        Item current = this.pop();
        ArrayStack temp = new ArrayStack<Item>();
        while (current != null) {
            if (x.equals(current)) {

            } else {
                temp.push(current);
            }
            current = this.pop();
        }
        current = temp.pop();
        while (current != null) {
            this.push(current);
            current = temp.pop();
        }
    }
}