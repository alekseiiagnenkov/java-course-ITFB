package ru.mephi.seminar3.homework.functionalInterfaces;

import java.util.function.Supplier;

public interface MySupplier<T> extends Supplier<T> {

    T get();

}
