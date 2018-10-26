public class Tree {
    protected Node root = null;
    public Tree(){ }

    public boolean isEmpty() {
        return root == null;
    }

    public Node returnRoot() {
        return this.root;
    }

    public void insert(int value) {
        Node current = root;
        Node prev = null;

        while(current != null) {
            prev = current;
            if (current.value < value) {
                current = current.right;
            } else  {
                current = current.left;
            }
        }
        if (root == null) {
            root = new Node(value);
        } else if (prev.value < value) {
            prev.right = new Node(value);
        } else  {
            prev.left = new Node(value);
        }
    }

    public boolean isEvenSum(int operanda, int operandb) {
        int sum = 0;
        if (root != null) {
            sum = rangeTraverser(root, operanda, operandb);
        }
        boolean booler = false;
        if (sum%2 == 0) {
            booler = true;
        }
        return booler;
    }

    private static int rangeTraverser(Node root, int operanda, int operandb) {
        int sum = 0;
        Node leftChild = root.left;
        Node rightChild = root.right;
        if (root.value >= operanda && root.value <= operandb) {
            sum = root.value;
        }
        if (leftChild != null && root.value > operanda) {
            root = leftChild;
            sum += rangeTraverser(root, operanda, operandb);
        }
        if (rightChild != null && root.value < operandb) {
            root = rightChild;
            sum += rangeTraverser(root, operanda, operandb);
        }
        return sum;
    }

    private void treePrinter(Node current) {
        if (current != null) {
            treePrinter(current.left);
            System.out.println(current.value + " ");
            treePrinter(current.right);
        }
    }

    public void treePrinter() {
        treePrinter(root);
    }
}
