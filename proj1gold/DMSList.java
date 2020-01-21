public class DMSList {
    private IntNode sentinel;

    public DMSList() {
        sentinel = new IntNode(-1000, new SentNode());
    }

    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode h) {
            item = i;
            next = h;
        }
        public int max() {
            return Math.max(item, next.max());
        }
    }
    public class SentNode extends IntNode {
        public SentNode() {
            super(0, null);
        }

        @Override
        public int max() {
            return item;
        }
    }

    public int max() {
        return sentinel.next.max();
    }
}
