/**
 * ListOfInts
 */
public interface ListOfInts {

    public void addLast(int i);

    public int get(int i);

    public int size();

    public void set(int i, int value);

    default public void plusEquals(ListOfInts x) { // assume x is non-null
        if (size() != x.size()) {
            return;
        }
        for (int i = 0; i < size(); i++) {
            this.set(i, get(i) + x.get(i));
        }
    }
}