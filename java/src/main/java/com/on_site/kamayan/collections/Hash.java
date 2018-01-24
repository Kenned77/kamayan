package com.on_site.kamayan.collections;

import com.on_site.kamayan.Kamayan;
import com.on_site.kamayan.Ref;

public class Hash {
    private DoublyLinkedList[] hash;
    private int size;

    private static class Entry {
        private final Object key;
        private Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

    public Hash() {
        this.hash = new DoublyLinkedList[10];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public Hash put(Object key, Object value) {

        if (key == null) {
            throw new NullPointerException("Not a valid key!");
        }

        int index = key.hashCode() % hash.length;

        if (hash[index] == null) {
            hash[index] = new DoublyLinkedList();
        }

        DoublyLinkedList list = hash[index];

        // list.each(new Consumer<Object>() {
        //     public void accept(Object obj) {
        //         ;
        //     }
        // });
        // Ref<Boolean> found = new Ref<>(false);
        Ref<Boolean> found = Ref.of(false);

        list.each((obj) -> {
            Entry entry = (Entry) obj;

            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                found.set(true);
            }
        });

        if (!found.get()) {
            Entry entry = new Entry(key, value);
            list.add(entry);
        }

        this.size++;
        return this;
    }

    public Object get(Object key) {
        int index = key.hashCode() % hash.length;
        DoublyLinkedList list = hash[index];

        if (list == null) {
            throw new MissingKeyException("Not a valid key bla bla!");
        }

        Entry entry = (Entry) list.first();
        return entry.getValue();

    }

    public boolean contains(Object key) {
        throw Kamayan.todo(
        );
    }
}
