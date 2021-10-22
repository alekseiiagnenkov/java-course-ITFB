package ru.mephi.seminar3.homework.functionalInterfaces;

import java.util.function.BiPredicate;

public interface MyBiPredicate<T, U> extends BiPredicate<T, U> {

    boolean test(T t, U u);

}
