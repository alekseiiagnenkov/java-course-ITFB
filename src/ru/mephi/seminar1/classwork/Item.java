package ru.mephi.seminar1.classwork;

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