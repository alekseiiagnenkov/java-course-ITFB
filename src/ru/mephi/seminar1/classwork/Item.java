package ru.mephi.seminar1.classwork;

import java.util.Objects;

public class Item {

    private Object value;
    private Item next;

    Item(Object value) {
        this.value = value;
        this.next = null;
    } //+

    @Override
    public String toString() {
        return " Item [" +
                "value_=" + value +
                ']';
    } //+

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(this.value, item.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    public Object getValue() {
        return value;
    }

    public Item getNext() {
        return next;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(Item next) {
        this.next = next;
    }
}