package ru.mephi.seminar1.homework;

/**
 * @author https://github.com/alekseiiagnenkov<br><br>
 * My Pair, made for {@link MyMap}.
 */
public class Pair {
    private Object key;
    private Object value;

    /**
     * Constructor.
     * @param key the first parameter
     * @param value the second parameter
     */
    public Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Getter.
     * @return value of the Pair
     */
    public Object getValue() {
        return value;
    }

    /**
     * Getter.
     * @return key of the Pair
     */
    public Object getKey() {
        return key;
    }

    /**
     * Setter.
     * @param value new value of the Pair
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Setter.
     * @param key new key of the Pair
     */
    public void setKey(Object key) {
        this.key = key;
    }

    /**
     * Comparing this Pair with another.
     * @param o presumably another Pair
     * @return <b>true</b> if equal, <b>false</b> if not equal
     */
    @Override
    public boolean equals(Object o) {
        if (o != null)
            return this.key == ((Pair) o).key && this.value == ((Pair) o).value;
        return false;
    }
}
