package com.neo.lab7;

import java.util.Iterator;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class BSTMap<K extends Comparable<K>, V> implements Map61B {
    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void clear() {

    }

    private boolean containsKeyRec(K mkey, BSTNode mRoot) {
        if (mRoot == null) return false;
        int cmp = mkey.compareTo(mRoot.key);
        if (cmp < 0) {
            return containsKeyRec(mkey, mRoot.left);
        } else if (cmp > 0) {
            return containsKeyRec(mkey, mRoot.left);
        } else {
            return true;
        }
    }

    @Override
    public boolean containsKey(Object key) {
        return containsKeyRec((K) key, root);
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void putRec(K key, V value,
                        BSTNode mRoot) {
        if (mRoot == null) {
            root = new BSTNode(key, value);
            size++;
        } else {
            int comp = key.compareTo(mRoot.key);
            if (comp < 0) {
                putRec(key, value, mRoot.left);
            } else if (comp > 0) {
                putRec(key, value, mRoot.right);
            }
            mRoot.value = (V) value;
        }
    }

    @Override
    public void put(Object key, Object value) {
        putRec((K) key, (V) value, root);
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

    @Override
    public Iterator iterator() {
        return null;
    }

    private boolean isEmpty() {
        return size == 0;
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
           left = null;
           right = null;
       }
    }

    public static void main(String[] args) {
        BSTMap<Integer, String> maptest = new BSTMap<>();
        maptest.put(1, "ivie");
        maptest.put(2, "ivie");
        maptest.put(3, "ivie");
        System.out.println(maptest.size());
    }
}
