package ru.mephi.seminar3.classwork;

import lombok.val;

public enum Role {
    STAFF(0.1),
    MANAGER(0.2),
    EXECUTIVE(0.3);

    private double value;

    private Role(double value){
        this.value = value;
    }

    double getValue(){
        return this.value;
    }
}