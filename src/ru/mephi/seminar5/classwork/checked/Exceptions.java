package ru.mephi.seminar5.classwork.checked;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exceptions {

    /**
     * Вызываем ArrayIndexOutOfBoundsException путем вызова элемента по несуществующему индексу
     */
    public static void throwArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException {
        int arr[] = {1, 2, 3};
        int g = arr[100]; // вызов происходит тут
    }

    /**
     * Вызываем FileNotFoundException путем считывания несуществующего файла
     */
    public static void throwFileNotFoundException() throws IOException {
        try (FileReader test = new FileReader("hello_world.txt")) {} // вызов происходит тут
    }

    /**
     * Вызываем NullPointerException путем преобразования null к строчке
     *
     * @param someThing переданный элемент(null)
     */
    public static void throwNullPointerException(Object someThing) throws NullPointerException {
        someThing.toString(); // вызов происходит тут
    }

    /**
     * Вызываем IOException когда пытаемся прочитать закрытый файл
     */
    public static void throwIOException() throws IOException {
        try (FileWriter test = new FileWriter("test.txt")) {
            test.close();
            test.write(10); // вызов происходит тут
        } finally{
            File test = new File ("test.txt");
            test.delete();
        }
    }

    /**
     * Вызываем ClassCastException путем каста Integer к String (для этого есть метод toString())
     */
    public static void throwClassCastException() throws ClassCastException {
        Object g = 0;
        System.out.println((String) g); // вызов происходит тут
    }

    /**
     * Вызываем ArithmeticException путем деления числа на 0
     */
    public static void throwArithmeticException() throws ArithmeticException {
        int num = 10 / 0; // вызов происходит тут
    }

    public static void main(String[] args) {
        try {
            throwArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage() + '\n' + e.getClass() + '\n');
        }

        try {
            throwFileNotFoundException();
        } catch (IOException e) {
            System.out.println(e.getMessage() + '\n' + e.getClass() + '\n');
        }

        try {
            throwNullPointerException(null);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage() + '\n' + e.getClass() + '\n');
        }

        try {
            throwClassCastException();
        } catch (ClassCastException e) {
            System.out.println(e.getMessage() + '\n' + e.getClass() + '\n');
        }

        try {
            throwIOException();
        } catch (IOException e) {
            System.out.println(e.getMessage() + '\n' + e.getClass() + '\n');
        }

        try {
            throwArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage() + '\n' + e.getClass() + '\n');
        }
    }
}
