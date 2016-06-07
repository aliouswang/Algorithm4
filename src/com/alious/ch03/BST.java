package com.alious.ch03;

/**
 * Created by aliouswang on 16/6/6.
 */
public class BST<K extends Comparable<K>, V>{

    private Node root;

    private int size;

    private class Node {

        public Node left;
        public Node right;

        public K key;
        public V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    public void put(K key, V value) {
        put(root, key, value);
    }

    private void put(Node root, K key, V value) {
        if (root == null) {
            this.root = new Node(key, value);
            size ++;
            return;
        }else {
            if (root.key.compareTo(key) > 0) {
                if (root.left != null) {
                    put(root.left, key, value);
                }else {
                    root.left = new Node(key, value);
                    size ++;
                    return;
                }
            }else if (root.key.compareTo(key) < 0) {
                if (root.right != null) {
                    put(root.right, key, value);
                }else {
                    root.right = new Node(key, value);
                    size ++;
                    return;
                }
            }else {
                root.value = value;
            }
        }
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node root, K key) {
        if (root == null) return null;
        if (root.key.compareTo(key) > 0) {
            return get(root.left, key);
        }else if (root.key.compareTo(key) < 0) {
            return get(root.right, key);
        }else return root.value;
    }

    private Node getMinNode(Node root) {
        while (root != null) {
            if (root.left != null) {
                root = root.left;
            }else {
                return root;
            }
        }
        return null;
    }

    public boolean delete(K key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        if (isEmpty()) return false;
        while (current.key.compareTo(key) != 0) {
            parent = current;
            if (current.key.compareTo(key) > 0) {
                isLeftChild = true;
                current = parent.left;
            }else if (current.key.compareTo(key) < 0) {
                isLeftChild = false;
                current = parent.right;
            }
            if (current == null) return false;
        }
        //if i am here that means we has found the node.
        //if the node is a leaf
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }else {
                if (isLeftChild) {
                    parent.left = null;
                }else parent.right = null;
            }
        }else if (current.left != null && current.right == null) {
            if (current == root) {
                root = current.left;
            }else {
                if (isLeftChild) {
                    parent.left = current.left;
                }else parent.right = current.left;
            }
        }else if (current.right != null && current.left == null) {
            if (current == root) {
                root = current.right;
            }else {
                if (isLeftChild) {
                    parent.left = current.right;
                }else parent.right = current.right;
            }
        }else if (current.left != null && current.right != null) {
            Node minNode = getMinRight(current);
            if (current == root) {
                root = minNode;
            }else {
                if (isLeftChild) {
                    parent.left = minNode;
                }else {
                    parent.right = minNode;
                }
            }
            minNode.left = current.left;
        }
        return true;
    }

    public void printRoot() {
        if (root != null) {
            System.out.println("root :" + root.key);
        }
    }

    private Node getMinRight(Node deleteNode) {
        Node result = null;
        Node resultParent = null;
        Node current = deleteNode.right;
        while (current != null) {
            resultParent = current;
            result = current;
            current = current.left;
        }
        if (result != deleteNode.right) {
            resultParent.left = result.right;
            result.right = deleteNode.right;
        }
        return result;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    private String traverse(Node root) {
        if (root == null) {
            return "";
        }else {
            return traverse(root.left) + "," + root.value + "," + traverse(root.right);
        }
    }

    @Override
    public String toString() {
        return traverse(root);
    }
}
