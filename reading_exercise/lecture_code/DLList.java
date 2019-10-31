/**
 * DLList
 */
public class DLList {

    private IntNode sentNode;
    private int size;

    private class IntNode {
        private IntNode prev;
        private int item;
        private IntNode next;

        public IntNode(int i, IntNode p, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public DLList() {
        size = 0;
        sentNode = new IntNode(63, null, null);
        sentNode.prev = sentNode;
        sentNode.next = sentNode;
    }

    public DLList(int x) {
        size = 1;
        sentNode = new IntNode(63, null, null);
        IntNode node = new IntNode(x, sentNode, sentNode);
        sentNode.prev = node;
        sentNode.next = node;
    }

    public void addFirst(int x) {
        IntNode node = new IntNode(x, sentNode, sentNode.next);
        sentNode.next = node;
        node.next.prev = node;
        size += 1;
    }
    
    public int getFirst() {
        return sentNode.next.item;
    }

    public void addLast(int x) {
        IntNode node = new IntNode(x, sentNode.prev, sentNode);
        sentNode.prev = node;
        node.prev.next = node;
        size += 1;
    }

    public int getLast() {
        return sentNode.prev.item;
    }

    public void removeLast() {
        IntNode newLast = sentNode.prev.prev;
        sentNode.prev = newLast;
        newLast.next = sentNode;
        if (size > 0) {
            size -= 1;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        DLList L = new DLList();
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.size());
        L.removeLast();
        System.out.println(L.size());
    }
}