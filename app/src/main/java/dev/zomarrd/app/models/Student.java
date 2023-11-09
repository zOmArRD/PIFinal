package dev.zomarrd.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    private int grade;
}
