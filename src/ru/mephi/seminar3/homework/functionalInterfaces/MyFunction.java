package ru.mephi.seminar3.homework.functionalInterfaces;

import java.util.function.Function;

public interface MyFunction<T, R> extends Function<T, R> {

    R apply(T t);

}
