package com.neo.lab7;

import java.util.Iterator;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class BSTMap<K extends Comparable<K>, V> implements Map61B {
    public BSTMap() {
        root = null;
        size = 0;
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

    @Override
    public Iterator iterator() {
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

    public static void main(String[] args) {
        BSTMap<Integer, String> map = new BSTMap<>();
        map.put(1, "ivie");
        map.put(2, "ivie");
        map.put(3, "ivie");
        System.out.println(map.size());
        System.out.println(map.get(1));
        map.clear();
        System.out.println(map.size());
    }
}
