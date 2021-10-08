package ru.mephi.seminar1.homework;

import ru.mephi.seminar1.classwork.MyList;

/**
 * @author https://github.com/alekseiiagnenkov<br><br>
 * My key / value collection<br>.
 * Uses {@link MyList} to store {@link Pair}s.
 */
public class MyMap {

    private final MyList<Pair> head;

    /**
     * Constructor.
     */
    public MyMap() {
        this.head = new MyList<>();
    }

    /**
     * Put a new <b>value</b> by <b>key</b>.
     * @param key search <b>key</b>
     * @param value new value
     */
    public void put(Object key, Object value) {
            for (int i = 0; i < this.head.size(); i++) {
                if ((this.head.get(i)).getKey() == key) {
                    (head.get(i)).setValue(value);
                    return;
                }
            }
        this.head.add(new Pair(key, value));
    }

    /**
     * Get value by <b>key</b>.
     * @param key search <b>key</b>
     * @return <b>value</b> if an element with such a key is found, otherwise <b>null</b>
     */
    public Object get(Object key) {
        if (!this.head.isEmpty()) {
            for (int i = 0; i < this.head.size(); i++) {
                Pair p = this.head.get(i);
                if (key == p.getKey())
                    return p.getValue();
            }
        }
        return null;
    }

    /**
     * Get the <b>value</b> by key, if the value is <b>null</b>,
     * then you need to return the <b>byDefault</b>,
     * which is set by the second parameter.
     * @param key search <b>key</b>
     * @param byDefault for unsuccessful search
     * @return the <b>value</b> of the found element if successful, otherwise <b>byDefault</b>
     */
    public Object get(Object key, Object byDefault) {
        if (this.keyContains(key)) {
            return this.get(key);
        }
        return byDefault;
    }

    /**
     * Remove a {@link Pair} by key.
     * @param key search <b>key</b>
     * @return the value of the deleted {@link Pair} or <b>null</b>
     */
    public Object remove(Object key) {
        if (!this.head.isEmpty()) {
            for (int i = 0; i < this.head.size(); i++) {
                Pair pair = (this.head.get(i));
                if (key == pair.getKey()) {
                    head.remove(i);
                    return pair.getValue();
                }
            }
        }
        return null;
    }

    /**
     * Checking for a <b>key</b> in the MyMap.
     * @param key search <b>key</b>
     * @return <b>True</b> if found, otherwise a <b>false</b>
     */
    //- Проверить наличие ключа:
    public boolean keyContains(Object key) {
        if (!this.head.isEmpty()) {
            for (int i = 0; i < this.head.size(); i++) {
                if (key == (this.head.get(i)).getKey()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get a {@link MyList} of <b>keys</b>.
     * @return {@link MyList} of <b>keys</b> or null
     */
    public MyList<Object> getKeys() {
        if (!this.head.isEmpty()) {
            MyList<Object> values = new MyList<>();
            for (int i = 0; i < this.head.size(); i++) {
                values.add((this.head.get(i)).getKey());
            }
            return values;
        }
        return null;
    }

    /**
     * Get a {@link MyList} of <b>values</b>.
     * @return {@link MyList} of <b>values</b> or null
     */
    public MyList<Object> getValues() {
        if (!this.head.isEmpty()) {
            MyList<Object> values = new MyList<>();
            for (int i = 0; i < this.head.size(); i++) {
                values.add((this.head.get(i)).getValue());
            }
            return values;
        }
        return null;
    }

    /**
     * Get a list of {@link MyList} type {@link Pair}s: <b>key</b>, <b>value</b>.
     * @return {@link MyList}
     */
    public MyList<Pair> getEntries() {
        return this.head;
    }

    /**
     * Map size.
     * @return returns the <b>size</b> with {@link MyList#size()}
     */
    public int size() {
        return this.head.size();
    }

    /**
     * Check for emptiness.
     * @return <b>true</b> or <b>false</b>
     */
    public boolean isEmpty() {
        return this.head.isEmpty();
    }

    /**
     * main for test
     */
    public static void main(String[] args) {
        MyMap map = new MyMap();
        map.put('o', 9);
        map.put('t', 5);
        map.put('u', 7);
        map.put('r', 4);
        map.put('u', 7);
        map.put('u', 777);
        map.put('e', 3);
    }
}
