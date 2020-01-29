package com.neo.lab7;

import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class BSTMap<K extends Comparable<K>, V> implements Map61B, Iterable {
    public BSTMap() {
        root = null;
        size = 0;
    }

    public class BSTMapIterator implements Iterator<K> {
        private Stack<BSTNode> stack;
        BSTNode mRoot;

        public BSTMapIterator() {
            stack = new Stack<>();
            mRoot = root;
            pushLeft(root);
        }

        @Override
        public boolean hasNext() {
            return (!stack.empty());
        }

        private void pushLeft(BSTNode mRoot) {
           while (mRoot != null) {
               stack.push(mRoot);
               mRoot = mRoot.left;
           }
        }

        @Override
        public K next() {
            BSTNode curr = stack.pop();
            pushLeft(curr.right);
            return curr.key;
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTMapIterator();
    }

    private BSTNode recClear(BSTNode mRoot) {
       if (mRoot == null) return null;
       mRoot.left = recClear(mRoot.left);
       mRoot.right = recClear(mRoot.right);
       mRoot = null;
       size--;
       return mRoot;
    }

    @Override
    public void clear() {
        root = recClear(root);
    }

    private boolean containsKeyRec(K mkey, BSTNode mRoot) {
        if (mRoot == null) return false;
        int cmp = mkey.compareTo(mRoot.key);
        if (cmp < 0) {
            return containsKeyRec(mkey, mRoot.left);
        } else if (cmp > 0) {
            return containsKeyRec(mkey, mRoot.right);
        } else {
            return true;
        }
    }

    @Override
    public boolean containsKey(Object key) {
        return containsKeyRec((K) key, root);
    }

    private Object getRec(Object key, BSTNode mRoot) {
       if (mRoot == null) return null;
       K mkey = (K) key;
       int comp = mkey.compareTo(mRoot.key);
       if (comp < 0) {
           return getRec(key, mRoot.left);
       } else if (comp > 0) {
          return getRec(key, mRoot.right);
       } return mRoot.value;
    }

    @Override
    public Object get(Object key) {
        return getRec(key, root);
    }

    @Override
    public int size() {
        return size;
    }

    private BSTNode putRec(K mkey, V mValue, BSTNode mRoot) {
        if (mRoot == null) {
            mRoot = new BSTNode(mkey, mValue);
            size++;
        } else {
            int comp = mkey.compareTo(mRoot.key);
            if (comp < 0) {
                mRoot.left = putRec(mkey, mValue, mRoot.left);
            } else if (comp > 0) {
                mRoot.right = putRec(mkey, mValue, mRoot.right);
            } else {
                mRoot.value = (V) mValue;
            }
        }
        return mRoot;
    }

    @Override
    public void put(Object key, Object value) {
       root =  putRec((K) key, (V) value, root);
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public Object remove(Object key, Object value) {
        return null;
    }

    private boolean isEmpty() {
        return (root == null) ||
                (size == 0);
    }

    private int size;
    private BSTNode root;

    private class BSTNode {
       BSTNode left;
       BSTNode right;
       K key;
       V value;

       public BSTNode(K key, V value) {
           this.key = key;
           this.value = value;
           this.left = null;
           this.right = null;
       }
    }

    private void printMapRec(BSTNode mRoot) {
        if (mRoot == null) {
            System.out.print(" -> ø");
        } else {
            printMapRec(mRoot.left);
            System.out.print("[" + mRoot.key + ":" +
                    mRoot.value + "]");
            printMapRec(mRoot.right);
        }
    }
    public void printMap() {
        printMapRec(root);
    }

    public static void main(String[] args) {
        BSTMap<Integer, String> map = new BSTMap<>();
        map.put(1, "ivie");
        map.put(2, "ivie");
        map.put(3, "ivie");
        map.printMap();
        System.out.println("");
        System.out.println("");
        System.out.println("printing with iterator");
        Iterator<Integer> iter = map.iterator();
        while (iter.hasNext()) {
            int val = iter.next();
            System.out.println(val + " : " + map.get(val) );
        }
    }
}
