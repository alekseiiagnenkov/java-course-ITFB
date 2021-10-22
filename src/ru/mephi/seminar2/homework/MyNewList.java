package ru.mephi.seminar2.homework;

import ru.mephi.seminar1.classwork.MyList;

/**
 * @param <T> any parameter that extends the Comparable
 * @author https://github.com/alekseiiagnenkov<br><br>
 * My generic class extending MyList class.<br>
 * The addAll function has been created.<br>
 */
public class MyNewList<T extends Comparable> extends MyList<T> {

    /**
     * Creates a new MyNewList that combines the elements of other and this.<br>
     * Cleans other.
     *
     * @param other another MyNewList of the same type
     */
    public void addAll(MyNewList<T> other) {
        while (other.size() != 0) {
            int i = 0;
            for (; this.get(i).compareTo(other.get(0)) < 0; i++) {
                if (i + 1 == this.size()) {
                    i++;
                    break;
                }
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
        list1.add(6);
        list1.add(7);

        MyNewList<Integer> list2 = new MyNewList<>();
        list2.add(-3);
        list2.add(2);
        list2.add(5);
        list2.add(9);
        list2.add(10);

        list1.addAll(list2);
        for (int i = 0; i < list1.size(); i++)
            System.out.println(list1.get(i));
    }
}