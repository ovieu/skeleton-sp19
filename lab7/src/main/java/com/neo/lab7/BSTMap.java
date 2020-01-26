package com.neo.lab7;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K, V> implements Map61B {
    public BSTMap() {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void put(Object key, Object value) {

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
    }
}
