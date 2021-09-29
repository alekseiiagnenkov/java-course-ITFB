package ru.mephi.seminar1.homework;

public class Pair {
    private Object key;
    private Object value;

    public Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Object getKey() {
        return key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null)
            return this.key == ((Pair) o).key && this.value == ((Pair) o).value;
        return false;
    }
}
