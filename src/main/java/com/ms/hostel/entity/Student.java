package com.ms.hostel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {

    private int roll;

    private String name;

    private String city;


    //contructor with student attributes
    public Student(int roll, String name, String city) {
        this.roll = roll;
        this.name = name;
        this.city = city;
    }

    public Student() {
    }


}
