package ru.mephi.seminar5.classwork.unchecked;

public class TestStackOverflowError {

    /**
     * Перегружаем стек, чтобы вызвать ошибку
     * @throws Error StackOverflowError
     */
    public static void recursiveMethod() throws Error{
        recursiveMethod(); // вызывается тут
    }

    public static void main(String[] arg) throws Error {
        recursiveMethod();
    }

}
