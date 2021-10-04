package ru.mephi.seminar2.homework;

import ru.mephi.seminar1.classwork.MyList;

public class MyNewList<T extends Comparable> extends MyList<T> {

    MyNewList<T> addAll(MyNewList<T> other) {
        MyNewList<T> head = new MyNewList<>();
        while (this.size() > 0 || other.size() > 0) {
            if (other.size() > 0 && this.size() > 0) {

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

    public static void main(String[] args) {

        MyNewList<Integer> list1 = new MyNewList<>();
        list1.add(-1);
        list1.add(1);
        list1.add(5);
        list1.add(6);
        list1.add(7);

        MyNewList<Integer> list2 = new MyNewList<>();
        list2.add(-3);
        list2.add(2);
        list2.add(5);
        list2.add(9);
        list2.add(10);

        MyNewList<Integer> head = list1.addAll(list2);
        for (int i = 0; i < head.size(); i++)
            System.out.println(head.get(i));
    }
}