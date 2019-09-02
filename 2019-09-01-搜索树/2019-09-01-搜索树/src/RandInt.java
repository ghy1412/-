import java.util.Random;
import java.util.TreeMap;

public class RandInt {
    public static class Node {
        int key;
        int value;
        Node left;
        Node right;
        Node parent;
    }

    public static void rotateLeft(Node node) {
        Node right = node.right;
        Node parent = node.parent;
        Node leftOfRight = right.left;

        right.left = node;
        node.right = leftOfRight;
        if (parent != null) {
            if (node == parent.left) {
                parent.left = right;
            } else {
                parent.right = right;
            }
        }

        right.parent = parent;
        node.parent = right;
        if (leftOfRight != null) {
            leftOfRight.parent = node;
        }
    }

    public static void main(String[] args) {
        Random random = new Random(20190902);
        for (int i = 0; i < 20; i++) {
            System.out.print(random.nextInt(100) + " ");
        }
        System.out.println();
    }
}
