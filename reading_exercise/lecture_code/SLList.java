/**
 * SLList
 */
public class SLList {

    // sentinel node to keep code simple
    private IntNode sentinel;
    private int size;
    private IntNode last;

    private class IntNode {
        private int item;
        private IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

    }

    // empty list constructor
    public SLList() {
        // sentinel node's item can set arbitrary value
        sentinel = new IntNode(63, null);
        last = sentinel;
        size = 0;
    }
    
    public SLList(int i) {
        sentinel = new IntNode(63, null); 
        sentinel.next = new IntNode(i, sentinel.next);
        last = sentinel.next;
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        size += 1;
        // IntNode node = sentinel;
        // while (node.next != null) {
        //     node = node.next;
        // }
        // node.next = new IntNode(x, null);
        last.next = new IntNode(x, null);
        last = last.next;
    }

    public int getLast() {
        return last.item;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList();
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.size());
    }
}