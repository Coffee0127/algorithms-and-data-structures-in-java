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
 * MainLinkedHashMap
 *
 * @author Bo-Xuan Fan
 * @since 2018-12-01
 */
public class MainLinkedHashMap {

    public static void main(String[] args) {
        HashMap map = new HashMap();

        // map.put(123, "1");
        // map.put(124, "2");
        // map.put(125, "3");
        // map.put(126, "4");
        //
        // System.out.println(map.get(123));
        //
        // map.remove(124);
        // System.out.println(map.get(124));

        int key = 123;
        int collisionKey = key + 128;
        map.put(key, "1");
        map.put(collisionKey, "2");

        System.out.println(map);
        System.out.println("----------------");
        map.remove(key);
        System.out.println(map);
    }

}
