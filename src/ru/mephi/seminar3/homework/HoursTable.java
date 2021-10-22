package ru.mephi.seminar3.homework;

import ru.mephi.seminar3.classwork.Employee;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Содержащая количество отработанных часов каждого {@link Employee}
 */
public class HoursTable {

    private Map<String, Integer> hours;

    /**
     * Пустой конструктор
     */
    HoursTable(){
        this.hours = new LinkedHashMap<>();
    }

    /**
     * Конструктор
     * @param list список {@link Employee}
     */
    HoursTable(List<Employee> list) {
        this.hours = new LinkedHashMap<>();
        for (Employee employee : list) {
            hours.put(employee.getPhone(), 0);
        }
    }

    /**
     * Получить мапу
     * @return мапу с данными
     */
    public Map<String, Integer> getHours() {
        return this.hours;
    }

    /**
     * Добавить часы {@link Employee}
     * @param employee {@link Employee}
     * @param hours сколько часов добавить
     * @return true, если человек есть, иначе false
     */
    public boolean addHours(Employee employee, int hours) {
        String phoneNumber = employee.getPhone();
        if (this.hours.containsKey(phoneNumber)) {
            this.hours.put(phoneNumber, this.hours.get(employee.getPhone()) + hours);
            return true;
        }
        return false;
    }

    /**
     * Добавить нового {@link Employee} в таблицу
     * @param employee новый {@link Employee}
     */
    public void addEmployee(Employee employee){
        this.hours.put(employee.getPhone(), 0);
    }

    /**
     * Получить часы работы {@link Employee}
     * @param employee интересующий нас {@link Employee}
     * @return его часы работы
     */
    public int getHours(Employee employee){
        return this.hours.get(employee.getPhone());
    }

}
