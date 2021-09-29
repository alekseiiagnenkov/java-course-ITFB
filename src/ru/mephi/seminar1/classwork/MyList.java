package ru.mephi.seminar1.classwork;

public class MyList {

    private Item head;

    public MyList() {
        this.head = null;
    }//+

    @Override
    public String toString() {
        return " MyList {" +
                "head=" + head +
                '}';
    } //+

    public void add(Object value) {
        Item it = new Item(value);
        if (this.head != null) {

            Item ptr = this.head;
            while (ptr.getNext() != null)
                ptr = ptr.getNext();
            ptr.setNext(it);

        } else {
            this.head = it;
        }
    } //+

    public Object remove(int index) {
        Object delValue = null;
        if (index > -1 && index < this.size()) {

            if (index == 0) {
                delValue = this.head;
                this.head = this.head.getNext();
            } else {
                Item ptr = this.head;
                for (int i = 0; i != index - 1; i++) {
                    ptr = ptr.getNext();
                }
                delValue = ptr.getNext();
                ptr.setNext(ptr.getNext().getNext());
            }
        }
        return delValue;
    } //+

    public void add(Object value, int index) {
        if (index > -1) {
            if (this.size() < index) {
                add(value);
            } else {
                Item it = new Item(value);
                if (index == 0) {
                    it.setNext(this.head);
                    this.head = it;
                } else {
                    Item ptr = this.head;
                    for (int i = 0; i != index - 1; i++) {
                        ptr = ptr.getNext();
                    }
                    it.setNext(ptr.getNext());
                    ptr.setNext(it);
                }
            }
        }
    } //+

    public Object get(int index) {
        if (this.head != null) {
            if (index < this.size()) {
                Item ptr = this.head;
                for (int i = 0; i != index; i++) {
                    ptr = ptr.getNext();
                }
                return ptr.getValue();
            }
        }
        return null;
    } //+

    public int indexOf(Object value) {
        if (this.head != null) {
            int i = 0;
            Item ptr = this.head;
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
    } //+

    public boolean contains(Object value) {
        Item ptr = this.head;
        while (ptr != null) {
            if (ptr.getValue() == value)
                return true;
            ptr = ptr.getNext();
        }
        return false;
    } //+

    public Item set(Object value, int index) {
        Item del = null;
        if (index > -1 && index < this.size()) {

            Item it = new Item(value);
            if (index == 0) {
                it.setNext(this.head.getNext());
                del = this.head;
                this.head = it;
            } else {
                Item ptr = this.head;
                for (int i = 0; i != index - 1; i++) {
                    ptr = ptr.getNext();
                }
                del = ptr.getNext();
                it.setNext(ptr.getNext().getNext());
                ptr.setNext(it);
            }
        }
        return del;
    } //+

    public int size() {
        int i = 0;
        Item ptr = this.head;
        for (; ptr != null; i++) {
            ptr = ptr.getNext();
        }
        return i;
    } //+

    public boolean isEmpty() {
        return this.head == null;
    } //+

    public static void main(String[] args) {
        MyList myList = new MyList();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(-3);
        myList.add(null);
        myList.add(4, 0);

        System.out.printf(" Size: %d\n Empty: %b\n IndexOf: %d\n Get: %s\n", myList.size(), myList.isEmpty(), myList.indexOf(5), myList.get(3));
    }
}
