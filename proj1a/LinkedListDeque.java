public class LinkedListDeque<T> {

    private IntNode sentNode;
    private int size;

    private class IntNode {
        private IntNode prev;
        private T item;
        private IntNode next;

        public IntNode(T i, IntNode p, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentNode = new IntNode(null, null, null);
        sentNode.prev = sentNode;
        sentNode.next = sentNode;
    }

    /*public LinkedListDeque(T x) {
        size = 1;
        sentNode = new IntNode(null, null, null);
        IntNode node = new IntNode(x, sentNode, sentNode);
        sentNode.prev = node;
        sentNode.next = node;
    }*/

//    public void insert(T x, int position) {
//        size += 1;
//        int i = 0;
//        if (position > size) {
//            position = size;
//        }
//        IntNode p = sentNode;
//        while (i != position) {
//            i += 1;
//            p = p.next;
//        }
//        IntNode node = new IntNode(x, p, p.next);
//        p.next.prev = node;
//        p.next = node;
//
//    }

    public void addFirst(T x) {
        IntNode node = new IntNode(x, sentNode, sentNode.next);
        sentNode.next = node;
        node.next.prev = node;
        size += 1;
    }

    public void addLast(T x) {
        IntNode node = new IntNode(x, sentNode.prev, sentNode);
        sentNode.prev = node;
        node.prev.next = node;
        size += 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        IntNode p = sentNode.next;
        while (p.item != null) {
            System.out.print(p.item + " ");
//            System.out.print(" ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        IntNode first = sentNode.next;
        sentNode.next = first.next;
        first.next.prev = sentNode;
        size = size - 1;
        return first.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        IntNode last = sentNode.prev;
        sentNode.prev = last.prev;
        last.prev.next = sentNode;
        size = size - 1;
        return last.item;
    }

    public T get(int i) {
        if (i >= size) {
            return null;
        }
        int index = 0;
        IntNode p = sentNode.next;
        while (i != index) {
            index = index + 1;
            p = p.next;
        }
        return p.item;
    }

    private T getRecursiveHelper(int index, IntNode node) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(index - 1, node.next);
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelper(index, sentNode.next);
    }

    /*public void reverse() {
        IntNode p = sentNode;
        IntNode moveNode = sentNode.prev;
        while (moveNode.item != null) {
            sentNode.prev = moveNode.prev;
//            sentNode.prev.next = sentNode;
            p.next = moveNode;
            moveNode.prev = p;

            moveNode = sentNode.prev;
            p = p.next;
        }
        p.next = sentNode;
    }

    public void reverseHelper(IntNode current, IntNode move) {
        if (move.item == null) {
            current.next = sentNode;
            return;
        }
        sentNode.prev = move.prev;
        current.next = move;
        move.prev = current;

        reverseHelper(current.next, sentNode.prev);
    }

    public void reverseRecursive() {
        reverseHelper(sentNode, sentNode.prev);
    }*/


}
