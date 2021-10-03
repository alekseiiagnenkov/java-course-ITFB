package ru.mephi.seminar1.classwork;

public class Item<T> {

    private T value;
    private Item<T> next;

    Item(T value) {
        this.value = value;
        this.next = null;
    } //+

    @Override
    public String toString() {
        return " Item [" +
                "value_=" + value +
                ']';
    } //+

    public T getValue() {
        return value;
    }

    public Item<T> getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Item<T> next) {
        this.next = next;
    }
}