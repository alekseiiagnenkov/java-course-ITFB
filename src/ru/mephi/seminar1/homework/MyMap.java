package ru.mephi.homework;

import ru.mephi.classwork.MyList;

class Pair {
    private Object key;
    private Object value;

    Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Object getKey() {
        return key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null)
            return this.key == ((Pair) o).key && this.value == ((Pair) o).value;
        return false;
    }
}

public class MyMap {

    MyList head;

    MyMap() {
        this.head = new MyList();
    } //+

    //- Положить по ключу значение:
    public void put(Object key, Object value) {
            for (int i = 0; i < this.head.size(); i++) {
                if (((Pair)this.head.get(i)).getKey() == key) {
                    ((Pair) head.get(i)).setValue(value);
                    return;
                }
            }
        this.head.add(new Pair(key, value));
    } //+

    //- Получить по ключу:
    public Object get(Object key) {
        if (!this.head.isEmpty()) {
            for (int i = 0; i < this.head.size(); i++) {
                Pair p = (Pair) this.head.get(i);
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
        return null;
    }

    //- Удалить по ключу, возвращает текущее
    //  значение
    public Object remove(Object key) {
        return null;
    }

    //- Проверить наличие ключа:
    public boolean keyContains(Object key) {
        if (!this.head.isEmpty()) {
            for (int i = 0; i < this.head.size(); i++) {
                if (key == ((Pair) this.head.get(i)).getKey()) {
                    return true;
                }
            }
        }
        return false;
    } //+

    //- Получить список ключей:
    public MyList getKeys() {
        if (!this.head.isEmpty()) {
            MyList values = new MyList();
            for (int i = 0; i < this.head.size(); i++) {
                values.add(((Pair) this.head.get(i)).getKey());
            }
            return values;
        }
        return null;
    } //+

    //- Получить список значений:
    public MyList getValues() {
        if (!this.head.isEmpty()) {
            MyList values = new MyList();
            for (int i = 0; i < this.head.size(); i++) {
                values.add(((Pair) this.head.get(i)).getValue());
            }
            return values;
        }
        return null;
    } //+

    //- Получить список пар: ключ, значение:
    public MyList getEntries() {
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
