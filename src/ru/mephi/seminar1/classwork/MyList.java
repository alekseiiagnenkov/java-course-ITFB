package ru.mephi.seminar1.classwork;

/**
 * @author https://github.com/alekseiiagnenkov<br><br>
 * My generic type List.
 * @param <T> any data type
 */
public class MyList<T> {

    private Item<T> head;

    /**
     * Constructor.
     */
    public MyList() {
        this.head = null;
    }

    /**
     * Overloaded method for easy Debugging.
     * @return my output format
     */
    @Override
    public String toString() {
        return " MyList {" +
                "head=" + head +
                '}';
    }

    /**
     * Adding a new <b>value</b> to the end of the MyList.<br>
     * It is possible to create 2 elements with the same <b>values</b>.
     * @param value new <b>value</b>
     */
    public void add(T value) {
        Item<T> it = new Item<>(value);
        if (this.head != null) {

            Item<T> ptr = this.head;
            while (ptr.getNext() != null)
                ptr = ptr.getNext();
            ptr.setNext(it);

        } else {
            this.head = it;
        }
    }

    /**
     * Removing an {@link Item} from a MyList by index.
     * @param index the index of the {@link Item} to remove
     * @return {@link Item} removed from the MyList
     */
    public Item<T> remove(int index) {
        Item<T> delValue = null;
        if (index > -1 && index < this.size()) {

            if (index == 0) {
                delValue = this.head;
                this.head = this.head.getNext();
            } else {
                Item<T> ptr = this.head;
                for (int i = 0; i != index - 1; i++) {
                    ptr = ptr.getNext();
                }
                delValue = ptr.getNext();
                ptr.setNext(ptr.getNext().getNext());
            }
        }
        return delValue;
    }

    /**
     * Adding a new <b>value</b> by index to MyList.<br>
     * It is possible to create 2 elements with the same <b>values</b>.<br>
     * <b>Doesn't replace the value at the index</b>.
     * @param value new <b>value</b>
     * @param index the index of the new {@link Item}
     */
    public void add(T value, int index) {
        if (index > -1) {
            if (this.size() < index) {
                add(value);
            } else {
                Item<T> it = new Item<>(value);
                if (index == 0) {
                    it.setNext(this.head);
                    this.head = it;
                } else {
                    Item<T> ptr = this.head;
                    for (int i = 0; i != index - 1; i++) {
                        ptr = ptr.getNext();
                    }
                    it.setNext(ptr.getNext());
                    ptr.setNext(it);
                }
            }
        }
    }

    /**
     * Getting a <b>value</b> by index.
     * @param index the index of the desired {@link Item}
     * @return The <b>value</b> of the found element if successful, otherwise <b>null</b>
     */
    public T get(int index) {
        if (this.head != null) {
            if (index < this.size()) {
                Item<T> ptr = this.head;
                for (int i = 0; i != index; i++) {
                    ptr = ptr.getNext();
                }
                return ptr.getValue();
            }
        }
        return null;
    }

    /**
     * Find the index of the closest {@link Item} by <b>value</b>.
     * @param value element <b>value</b>
     * @return If successful, the <b>index</b> of the {@link Item}, otherwise <b>-1</b>
     */
    public int indexOf(Object value) {
        if (this.head != null) {
            int i = 0;
            Item<T> ptr = this.head;
            while (ptr != null) {
                if (ptr.getValue() == value) {
                    break;
                }
                i++;
                ptr = ptr.getNext();
            }
            if (ptr != null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checking for the presence of a <b>value</b>.
     * @param value search <b>value</b>
     * @return <b>true</b> or <b>false</b>
     */
    public boolean contains(Object value) {
        Item<T> ptr = this.head;
        while (ptr != null) {
            if (ptr.getValue() == value)
                return true;
            ptr = ptr.getNext();
        }
        return false;
    }

    /**
     * Adding a new <b>value</b> by index to MyList.<br>
     * It is possible to create 2 elements with the same <b>values</b>.<br>
     * <b>Replace the {@link Item} at the index</b>.
     * @param value new <b>value</b>
     * @param index the index of the new {@link Item}
     * @return the replaced {@link Item}
     */
    public Item<T> set(T value, int index) {
        Item<T> del = null;
        if (index > -1 && index < this.size()) {

            Item<T> it = new Item<>(value);
            if (index == 0) {
                it.setNext(this.head.getNext());
                del = this.head;
                this.head = it;
            } else {
                Item<T> ptr = this.head;
                for (int i = 0; i != index - 1; i++) {
                    ptr = ptr.getNext();
                }
                del = ptr.getNext();
                it.setNext(ptr.getNext().getNext());
                ptr.setNext(it);
            }
        }
        return del;
    }

    /**
     * MyList size. Calculated by running all the {@link Item}.
     * @return MyList size
     */
    public int size() {
        int i = 0;
        Item<T> ptr = this.head;
        for (; ptr != null; i++) {
            ptr = ptr.getNext();
        }
        return i;
    }

    /**
     * Check for emptiness.
     * @return <b>true</b> or <b>false</b>
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * main for test
     */
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();

        myList.add(1);
        myList.add(2);
        myList.add(5);
        myList.add(-3);
        myList.add(null);
        myList.add(-5);
        myList.add(4, 0);
        System.out.printf(" Size: %d\n Empty: %b\n IndexOf: %d\n Get: %s\n", myList.size(), myList.isEmpty(), myList.indexOf(5), myList.get(3));
    }
}
