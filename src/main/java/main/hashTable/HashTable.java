package main.hashTable;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<String>[] table;
    private int capacity;
    private int size;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    @SuppressWarnings("unchecked")
    public HashTable(int initialCapacity) {
        this.capacity = initialCapacity;
        this.table = new LinkedList[capacity];
        this.size = 0;

        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void insert(String key) {
        if ((double) size / capacity >= LOAD_FACTOR_THRESHOLD) {
            resize();
        }

        int index = hash(key);
        if (!table[index].contains(key)) {
            table[index].add(key);
            size++;
        }
    }

    public boolean search(String key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    public void delete(String key) {
        int index = hash(key);
        if (table[index].remove(key)) {
            size--;
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        LinkedList<String>[] newTable = new LinkedList[newCapacity];

        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new LinkedList<>();
        }

        for (LinkedList<String> bucket : table) {
            for (String key : bucket) {
                int newIndex = Math.abs(key.hashCode()) % newCapacity;
                newTable[newIndex].add(key);
            }
        }

        table = newTable;
        capacity = newCapacity;
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.println(i + " -> " + table[i]);
        }
    }
}
