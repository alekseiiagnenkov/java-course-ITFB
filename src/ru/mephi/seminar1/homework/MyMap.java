package ru.mephi.seminar1.homework;

import ru.mephi.seminar1.classwork.MyList;

public class MyMap {

    private final MyList<Pair> head;

    public MyMap() {
        this.head = new MyList<>();
    } //+

    //- Положить по ключу значение:
    public void put(Object key, Object value) {
            for (int i = 0; i < this.head.size(); i++) {
                if ((this.head.get(i)).getKey() == key) {
                    (head.get(i)).setValue(value);
                    return;
                }
            }
        this.head.add(new Pair(key, value));
    } //+

    //- Получить по ключу:
    public Object get(Object key) {
        if (!this.head.isEmpty()) {
            for (int i = 0; i < this.head.size(); i++) {
                Pair p = this.head.get(i);
                if (key == p.getKey())
                    return p.getValue();
            }
        }
        return null;
    } //+

    //- Получить по ключу,
    // если значение null, тогда надо
    // вернуть значение по умолчанию,
    // которое задается вторым параметром.
    // Значение по умолчанию необходимо
    // сохранить.
    public Object get(Object key, Object byDefault) {
        if (this.keyContains(key)) {
            return this.get(key);
        }
        return byDefault;
    }

    //- Удалить по ключу, возвращает текущее
    //  значение
    public Object remove(Object key) {
        if (!this.head.isEmpty()) {
            for (int i = 0; i < this.head.size(); i++) {
                Pair pair = (this.head.get(i));
                if (key == pair.getKey()) {
                    head.remove(i);
                    return pair.getValue();
                }
            }
        }
        return null;
    }

    //- Проверить наличие ключа:
    public boolean keyContains(Object key) {
        if (!this.head.isEmpty()) {
            for (int i = 0; i < this.head.size(); i++) {
                if (key == (this.head.get(i)).getKey()) {
                    return true;
                }
            }
        }
        return false;
    } //+

    //- Получить список ключей:
    public MyList<Object> getKeys() {
        if (!this.head.isEmpty()) {
            MyList<Object> values = new MyList<>();
            for (int i = 0; i < this.head.size(); i++) {
                values.add((this.head.get(i)).getKey());
            }
            return values;
        }
        return null;
    } //+

    //- Получить список значений:
    public MyList<Object> getValues() {
        if (!this.head.isEmpty()) {
            MyList<Object> values = new MyList<>();
            for (int i = 0; i < this.head.size(); i++) {
                values.add((this.head.get(i)).getValue());
            }
            return values;
        }
        return null;
    } //+

    //- Получить список пар: ключ, значение:
    public MyList<Pair> getEntries() {
        return this.head;
    } //+

    //- Размер словаря:
    public int size() {
        return this.head.size();
    } //+

    //- Пустой или нет:
    public boolean isEmpty() {
        return this.head.isEmpty();
    } //+

    public static void main(String[] args) {
        MyMap map = new MyMap();
        map.put('o', 9);
        map.put('t', 5);
        map.put('u', 7);
        map.put('r', 4);
        map.put('u', 7);
        map.put('u', 777);
        map.put('e', 3);
    }
}
