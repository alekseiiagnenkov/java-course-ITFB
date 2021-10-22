package ru.mephi.seminar2.homework;

import ru.mephi.seminar1.classwork.MyList;

/**
 * @param <T> any parameter that extends the Comparable
 * @author https://github.com/alekseiiagnenkov<br><br>
 * My generic class extending MyList class.<br>
 * The addAll function has been created.<br>
 */
public class MyNewList<T extends Comparable> extends MyList<T> {

    //TODO передеделать так, чтобы добавляла в this, а не в новый

    /**
     * Creates a new MyNewList that combines the elements of other and this.<br>
     * Cleans other and this.
     *
     * @param other another MyNewList of the same type
     * @return sorted MyNewList containing elements from this and other
     */
    public MyNewList<T> addAll(MyNewList<T> other) {
        MyNewList<T> head = new MyNewList<>();
        while (this.size() > 0 || other.size() > 0) {
            if (other.size() > 0 && this.size() > 0) {

                if (this.get(0) == null) {
                    this.remove(0);
                }
                if (other.get(0) == null) {
                    other.remove(0);
                }

                if (other.get(0).compareTo(this.get(0)) < 0) {
                    head.add(other.remove(0).getValue());
                } else {
                    head.add(this.remove(0).getValue());
                }

            } else if (this.size() != 0) {
                head.add(this.remove(0).getValue());
            } else if (other.size() != 0) {
                head.add(other.remove(0).getValue());
            }
        }

        return head;
    }

    public void addAll1(MyNewList<T> other) {
        while (other.size() != 0) {
            int i = 0;
            while (this.get(i).compareTo(other.get(0)) > 0) {
                i++;
            }
            this.add(other.remove(0).getValue(), i);
        }
    }

    /**
     * main for test
     */
    public static void main(String[] args) {

        MyNewList<Integer> list1 = new MyNewList<>();
        list1.add(-1);
        list1.add(1);
        list1.add(null);
        list1.add(6);
        list1.add(7);

        MyNewList<Integer> list2 = new MyNewList<>();
        list2.add(-3);
        list2.add(2);
        list2.add(5);
        list2.add(9);
        list2.add(10);

/*        MyNewList<Integer> head = list1.addAll(list2);
        for (int i = 0; i < head.size(); i++)
            System.out.println(head.get(i));*/

        list1.addAll1(list2);
        for (int i = 0; i < list1.size(); i++)
            System.out.println(list1.get(i));
    }
}