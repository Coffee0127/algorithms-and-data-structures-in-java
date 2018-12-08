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
package io.github.coffee0127.data_structures.hashmap.simple;

/**
 * HashMap
 *
 * @author Bo-Xuan Fan
 * @since 2018-11-29
 */
public class HashMap {

    private static final int TABLE_SIZE = 128;

    private HashEntry[] table;

    public HashMap() {
        table = new HashEntry[TABLE_SIZE];
    }

    public int getKey(String userName) {
        int key = 0;

        for (int i = 0; i < userName.length(); i++) {
            key += userName.charAt(i);
        }

        return key;
    }

    public void put(int key, String value) {
        int hash = convertToHash(key);
        table[hash] = new HashEntry(key, value);
    }

    public String get(int key) {
        int hash = convertToHash(key);
        if (table[hash] == null) {
            return "Was not found";
        }
        return table[hash].getValue();
    }

    private int convertToHash(int key) {
        int initialHash = key % TABLE_SIZE;
        int hash = initialHash;
        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;

            if (hash == initialHash) {
                throw new RuntimeException("Hash Map is full.");
            }
        }
        return hash;
    }
}
