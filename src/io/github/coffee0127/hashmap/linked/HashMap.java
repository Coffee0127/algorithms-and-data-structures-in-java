/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Bo-Xuan Fan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.coffee0127.hashmap.linked;

/**
 * HashMap
 *
 * @author Bo-Xuan Fan
 * @since 2018-12-01
 */
public class HashMap {

    private static final int TABLE_SIZE = 128;

    private LinkedHashEntry[] table;

    public HashMap() {
        table = new LinkedHashEntry[TABLE_SIZE];
    }

    public int getKey(String userName) {
        int key = 0;

        for (int i = 0; i < userName.length(); i++) {
            key += userName.charAt(i);
        }

        return key;
    }

    public void put(int key, String value) {
        int hash = key % TABLE_SIZE;
        if (table[hash] == null) {
            table[hash] = new LinkedHashEntry(key, value);
        } else {
            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != key) {
                entry = entry.getNext();
            }

            if (entry.getKey() == key) {
                // replace the original key-value
                entry.setValue(value);
            } else {
                // create the next LinkedHashEntry
                entry.setNext(new LinkedHashEntry(key, value));
            }
        }
    }

    public String get(int key) {
        int hash = key % TABLE_SIZE;
        if (table[hash] == null) {
            return "Does not exist";
        }

        LinkedHashEntry entry = table[hash];
        while (entry != null && entry.getKey() != key) {
            entry = entry.getNext();
        }

        if (entry == null) {
            return "Does not exist";
        }

        return entry.getValue();
    }

    public void remove(int key) {
        int hash = key % TABLE_SIZE;

        if (table[hash] != null) {
            LinkedHashEntry prevEntry = null;
            LinkedHashEntry entry = table[hash];

            while (entry.getNext() != null && entry.getKey() != key) {
                prevEntry = entry;
                entry = entry.getNext();
            }

            if (entry.getKey() == key) {
                if (prevEntry == null) {
                    table[hash] = entry.getNext();
                } else {
                    prevEntry.setNext(entry.getNext());
                }
            }
        }
    }
}
