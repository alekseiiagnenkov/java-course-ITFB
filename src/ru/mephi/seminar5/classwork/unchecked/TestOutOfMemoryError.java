package ru.mephi.seminar5.classwork.unchecked;

public class TestOutOfMemoryError {

    /**
     * Бесконечно добавляем строку, пока не закончится память
     * @throws Error OutOfMemoryError
     */
    public static void main(String[] arg) throws Error {
        StringBuilder str = new StringBuilder();
        while (true) {
            str.append("HelloWorld"); //вызывается тут
        }
    }

}
