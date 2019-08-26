import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Trees {
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }

    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.val);
    }

    public static List<Integer> preorderReturn1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        process(list, root);
        return list;
    }

    private static void process(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        process(list, root.left);
        process(list, root.right);
    }

    public static List<Integer> preorderReturn2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        // 汇总
        // 根的情况 + 左子树的情况 + 右子树的情况
        List<Integer> leftList = preorderReturn2(root.left);
        List<Integer> rightList = preorderReturn2(root.right);

        list.add(root.val);
        list.addAll(leftList);
        list.addAll(rightList);
        return list;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        int height = Math.max(left, right) + 1;
        return height;
    }

    // 1. 起始状态下，树不是空树
    // 2. p 和 q 一定是树中的两个结点，并且是不同的两个结点
    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }

        boolean pInLeft = search(root.left, p);
        boolean qInLeft = search(root.left, q);

        if (pInLeft && qInLeft) {
            return commonAncestor(root.left, p, q);
        }

        if (!pInLeft && !qInLeft) {
            return commonAncestor(root.right, p, q);
        }

        return root;
    }

    private static boolean search(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }

        if (root == p) {
            return true;
        }

        if (search(root.left, p)) {
            return true;
        }

        return search(root.right, p);
    }

    // 找包含 val 的结点，找到返回结点引用，否则返回 null
    public static TreeNode searchVal(TreeNode root, int val) {
        if (root == null) {
            // 返回找不到
            return null;
        }
        if (root.val == val) {
            // root 是包含 val 的结点
            return root;
        }

        // 去我的左子树中查找
        TreeNode r = searchVal(root.left, val);
        // 根据查找结果，判断左子树中是否找到？ 如果找到，结果 != null
        if (r != null) {
            // 如果找到，返回什么？
            // r 就是包含 val 的结点
            return r;
        }

        return searchVal(root.right, val);
    }

    public static TreeNode prev = null;
    public static TreeNode first = null;
    public static void process(TreeNode node) {
        node.left = prev;
        if (prev != null) {
            prev.right = node;
        } else {
            first = node;
        }
        prev = node;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            process(root);
            inorder(root.right);
        }
    }

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front == null) {
                continue;
            }
            System.out.println(front.val);
            queue.add(front.left);
            queue.add(front.right);
        }
    }

    public static void levelOrderTraversal2(TreeNode root) {
        if (root != null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            System.out.println(front.val);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }

    public static boolean isCompleteTree(TreeNode root) {
        // 第一阶段，不断的层序遍历，直到遇到一个 null 为止
        // 隐含着队列中是会被插入 null
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            TreeNode front = queue.poll();
            if (front == null) {
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }
        // 第二阶段，检查队列剩余结点中是否还有 not null 的情况
        Set<TreeNode> set = new HashSet<>(queue);
        return set.size() == 1;
        /*
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front != null) {
                return false;
            }
        }

        return true;
        */
    }
}
