package ru.mephi.sem1;

public class MyList {

    private Item head;

    private static class Item {

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
    }

    MyList() {
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
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = it;

        } else {
            this.head = it;
        }
    } //+

    public Object remove(int index) {
        Object delValue = null;
        if (index > -1 && index < this.size()) {

            if (index == 0) {
                delValue = this.head;
                this.head = this.head.next;
            } else {
                Item ptr = this.head;
                for (int i = 0; i != index - 1; i++, ptr = ptr.next) ;
                delValue = ptr.next;
                ptr.next = ptr.next.next;
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
                    it.next = this.head;
                    this.head = it;
                } else {
                    Item ptr = this.head;
                    for (int i = 0; i != index - 1; i++, ptr = ptr.next) ;
                    it.next = ptr.next;
                    ptr.next = it;
                }
            }
        }
    } //+

    public Object get(int index) {
        if (this.head != null) {
            if (index < this.size()) {
                Item ptr = this.head;
                for (int i = 0; i != index; i++, ptr = ptr.next) ;
                return ptr.value;
            }
        }
        return null;
    } //+

    public int indexOf(Object value) {
        if (this.head != null) {
            int i = 0;
            Item ptr = this.head;
            while (ptr != null) {
                if (ptr.value == value) {
                    break;
                }
                i++;
                ptr = ptr.next;
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
            if (ptr.value == value)
                return true;
            ptr = ptr.next;
        }
        return false;
    } //+

    public Item set(Object value, int index) {
        Item del = null;
        if (index > -1 && index < this.size()) {

            Item it = new Item(value);
            if (index == 0) {
                it.next = this.head.next;
                del = this.head;
                this.head = it;
            } else {
                Item ptr = this.head;
                for (int i = 0; i != index - 1; i++, ptr = ptr.next) ;
                del = ptr.next;
                it.next = ptr.next.next;
                ptr.next = it;
            }
        }
        return del;
    } //+

    public int size() {
        int i = 0;
        for (Item ptr = this.head; ptr != null; i++, ptr = ptr.next) ;
        return i;
    } //+

    public boolean isEmpty() { return this.head == null; } //+

    public static void main(String[] args) {
        MyList myList = new MyList();

        myList.add(1);
        myList.add(2);
        myList.add(3);

        myList.add(4, 0);
        myList.add(6, 2);
        myList.add(8, -1);
        myList.add(5, 9);
        myList.add(7, myList.size());

        myList.set(9, 0);
        myList.set(10, 3);
        myList.set(11, -1);
        myList.set(12, 15);
        myList.set(13, myList.size() - 1);

        myList.remove(0);
        myList.remove(3);
        myList.remove(-1);
        myList.remove(7);
        myList.remove(myList.size() - 1);

        System.out.printf(" Size: %d\n Empty: %b\n IndexOf: %d\n Get: %s\n", myList.size(), myList.isEmpty(), myList.indexOf(5), myList.get(3));
    }
}
