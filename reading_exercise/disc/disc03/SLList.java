/**
 * SLList
 */
public class SLList {

    private class IntNode {
        private int item;
        private IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

    }

    private IntNode first;

    public SLList(int x) {
        first =  new IntNode(x, null);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }
}