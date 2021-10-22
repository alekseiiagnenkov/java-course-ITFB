package ru.mephi.seminar3.homework.functionalInterfaces;

import java.util.function.Consumer;

public interface MyConsumer<T> extends Consumer<T> {

    void accept(T t);

}
