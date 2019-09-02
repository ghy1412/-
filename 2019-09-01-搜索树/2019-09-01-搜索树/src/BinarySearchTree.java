public class BinarySearchTree {
    public static class Entry {
        int key;
        int value;

        Entry left;
        Entry right;
    }

    private Entry root = null;

    public int search(int key) {
        Entry cur = root;
        while (cur != null) {
            if (key == cur.key) {
                return cur.value;
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return -1;
    }

    public void insert(int key, int value) {
        Entry cur = root;
        Entry parent = null;
        while (cur != null) {
            parent = cur;
            if (key == cur.key) {
                throw new RuntimeException("key 重复了");
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        Entry node = new Entry();
        node.key = key; node.value = value;
        if (parent == null) {
            root = node;
            return;
        }

        if (key < parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    }

    public void remove(int key) {
        Entry cur = root;
        Entry parent = null;
        while (cur != null) {
            if (key == cur.key) {
                // 要删除的是 cur, parent 是 cur 的双亲结点
                removeNode(cur, parent);
            } else if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
    }

    private void removeNode(Entry cur, Entry parent) {
        if (cur.left == null) {
            if (parent == null) {
                root = cur.right;
            } else {
                if (cur == parent.left) {
                    parent.left = cur.right;
                } else {
                    parent.right = cur.right;
                }
            }
        } else if (cur.right == null){
            if (parent == null) {
                root = cur.left;
            } else {
                if (cur == parent.left) {
                    parent.left = cur.left;
                } else {
                    parent.right = cur.left;
                }
            }
        } else {
            Entry replacedParent = cur;
            Entry replaced = cur.right;
            while (replaced.left != null) {
                replacedParent = replaced;
                replaced = replaced.left;
            }

            cur.key = replaced.key;
            cur.value = replaced.value;
            if (replaced == replacedParent.left) {
                replacedParent.left = replaced.right;
            } else {
                replacedParent.right = replaced.right;
            }
        }
    }
}
