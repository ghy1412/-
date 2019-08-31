package com.cn;

import javafx.util.Pair;

import javax.swing.text.html.parser.Entity;
import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null){
            return true;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            if (('a' <= s.charAt(i)&& s.charAt(i) <= 'z') || ('A' <= s.charAt(i)&& s.charAt(i)<= 'Z')){
                sb.append(s.charAt(i));
            }
        }

        s = sb.toString();
        if (s == null){
            return true;
        }
        int low = 0;
        int high = s.length()-1;
        while(low < high){
            if (!s.substring(low,low+1).equalsIgnoreCase(s.substring(high, high+1))){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
class SSSSolution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int s = A.length+1;
        int ss = m+1;
        int[][] pack = new int[A.length+1][m+1];
        for(int i = 1; i <= A.length+1; i++){
            for(int j = 1; j <= m+1; j++){
                if (A[i-1] > j){
                    pack[i][j] = pack[i-1][j];
                } else {
                    int  newValue = pack[i-1][j-A[i-1]] + V[i-1];
                    pack[i][j] = Math.max(pack[i-1][j],newValue);
                }
            }
        }
        return pack[A.length][m];
    }
}
public class Test {





















    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static List<Integer> preorderTraversal(Node node) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();

        if (node != null) {
            stack.add(node);
        }

        while (!stack.isEmpty()) {
            Node node1 = stack.pollLast();
            list.add(node1.val);

            if (node1.right != null) {
                stack.add(node1);
            }

            if (node1.left != null) {
                stack.add(node1);
            }
        }
        return list;
    }

    public static List<Integer> inorderReturn(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        process(list, root);
        return list;
    }

    private static void process(LinkedList<Integer> list, Node root) {
        if (root == null) {
            return;
        }

        process(list, root.left);
        list.add(root.val);
        process(list, root.right);
    }

    //汇总的方法,遍历二叉数

    public List<Integer> preorderReturn(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        List<Integer> list1 = preorderReturn(root.left);
        List<Integer> list2 = preorderReturn(root.right);
        list.addAll(list1);
        list.addAll(list2);
        return list;
    }

    //用汇总的方法求树的高度

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        //求左右树的高度的最大值 再加自己的高度
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    //求公共的祖先
    //如果root 不为空的情况下  是走不到 root == null 的情况下
    public static Node commonAncestor(Node root, Node p, Node q) {
        //第一种情况
        if (root == p || root == q) {
            return root;
        }

        boolean pInLeft = search11(root, p);
        boolean qInLeft = search11(root, q);

        //p q 都在左边
        if (qInLeft && pInLeft) {
            commonAncestor(root.left, p, q);
        }

        //假如都在右边
        if (!qInLeft && !pInLeft) {
            commonAncestor(root.right, p, q);
        }

        //都不在左边, 或者都不在右边  那就左右各有一个 直接返回就好

        return root;
    }

    //用递归吧
    private static boolean search11(Node root, Node p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }

        if (search11(root.left, p)) {
            return true;
        }
        return search11(root.right, p);
    }


    //搜索val

    public static Node searchVal(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (root.val == value) {
            return root;
        }
        Node node = searchVal(root.left, value);
        if (node != null) {
            return node;
        }
        return searchVal(root.right, value);
    }

    //二叉搜索树 中序遍历得到有序序列 是和中序有关  组成双向链表
    //1.中序遍历然后组成一个双向链表


    //层序遍历
    //使用FIFO队列实现
    public static void levelOrderTraversal(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                continue;
            }
            System.out.println(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }

    }


    //层序变量里的题  判断是否为完全二叉树     层序遍历中没有空节点

    public static boolean isCompleteTree(Node root) {

        //第一阶段,不断层序遍历,直到遇到一个null位置
        LinkedList<Node> queue = new LinkedList();
        //得把空的情况也加进去,不然怎么可能在队列中找到空;
        queue.add(root);

        while (true) {
            Node node = queue.poll();
            if (node == null) {
                break;
            }

            queue.add(node.left);
            queue.add(node.right);
        }
        //第二阶段 ,检查剩余阶段是否还有not null的情况
        //因为是层序遍历,经过上一层的遍历,他的下一层也就是正在遍历的这一层,已经存储在了队列中
        //所以直接判断是否存在不为空的情况,而且 当前节点包括以前的节点都出了对列
        //等于说让 null也参与组成一颗二叉树

        //hash 会自动去重 剩一个null
  /*      HashSet<Node> nodes = new HashSet<>(queue);
        return nodes.size() == 1;
        */

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                return false;
            }
        }

        return true;
    }


    //堆  逻辑上是完全二叉树  但物理上是数组
    //二叉树如何用数组保存   层序遍历平铺在数组中
    //堆的基本功能是最值


    //向下调整也是堆化 heapify
    //建立大根堆
    public void heapify(int[] array, int size, int index) {
    }

    public void heapSort(int[] array, int size) {
        for (int i = size - 2 / 2; i >= 0; i--) {
            heapify(array, size, i);
        }
    }
}