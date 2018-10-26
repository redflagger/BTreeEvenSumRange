import java.util.StringTokenizer;


public class Node {
    protected int value;
    protected Node left, right;

    public Node() {
        left = null;
        right = null;
    }

    public Node (int value) {
        this(value, null, null);
    }

    public Node (int value, Node lt, Node rt) {
        this.value = value;
        left = lt;
        right = rt;
    }

}
