package ru.mephi.seminar1.classwork;

/**
 * @author https://github.com/alekseiiagnenkov<br><br>
 * My generic class Item for {@link MyList}.
 * @param <T> <b>value</b> class
 */
public class Item<T> {

    private T value;
    private Item<T> next;

    /**
     * Constructor.
     * @param value <b>value</b> for new Item
     */
    Item(T value) {
        this.value = value;
        this.next = null;
    } //+

    /**
     * Overloaded method for easy Debugging.
     * @return my output format
     */
    @Override
    public String toString() {
        return " Item [" +
                "value_=" + value +
                ']';
    } //+

    /**
     * Getter.
     * @return <b>value</b>
     */
    public T getValue() {
        return value;
    }

    /**
     * Getter.
     * @return <b>next</b>
     */
    public Item<T> getNext() {
        return next;
    }

    /**
     * Setter.
     * @param value new <b>value</b>
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Setter.
     * @param next new <b>next</b>
     */
    public void setNext(Item<T> next) {
        this.next = next;
    }
}