/**
 * DLListOfInts
 */
public class DLListOfInts implements ListOfInts {

    public class IntNode {
        public int item;
        public IntNode next, prev;
    }

    public IntNode sentinel;
    public int size;

    @Override
    public void plusEquals(DLListOfInts x) {
        if (x.size() != size()) {
            return;
        }
        IntNode px = x.sentinel.next;
        for (IntNode p = sentinel.next; p != sentinel; p = p.next) {
            p.item = p.item + px.item;
            px = px.next;
        }
    }
}

/**
 * 7(c) answer:
 * the method is destructive, modify the lists[0];
 */