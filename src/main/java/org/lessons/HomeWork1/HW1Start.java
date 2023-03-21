package org.lessons.HomeWork1;

import org.lessons.HomeWork1.cars.LightWeightCar;
import org.lessons.HomeWork1.cars.Lorry;
import org.lessons.HomeWork1.person.Person;
import org.lessons.HomeWork1.shapes.Canvas;
import org.lessons.HomeWork1.shapes.Circle;
import org.lessons.HomeWork1.shapes.Oval;
import org.lessons.HomeWork1.shapes.Triangle;

import java.util.HashMap;

public class HW1Start {
    public static void main(String[] args) {
        System.out.println("---------------------");
        System.out.println("1."); //первое задание
        Person person = Person.builder()
                .firstName("Alexey")
                .middleName("Vladimirovich")
                .lastName("Andreev")
                .address("Laplandia")
                .age(37)
                .country("Russia")
                .build();
        System.out.println(person.toString());

        System.out.println("---------------------");
        System.out.println("2."); //второе задание
        LightWeightCar lightWeightCar = new LightWeightCar();
        Lorry lorry = new Lorry();
        System.out.println("First car");
        lightWeightCar.open();
        lightWeightCar.getEngine().engineAction();
        lightWeightCar.move();
        lightWeightCar.stop();
        lightWeightCar.getEngine().engineAction();
        System.out.println("---------------------");
        System.out.println("Second car");
        lorry.getEngine().engineAction();
        lorry.move();
        lorry.stop();
        lorry.getEngine().engineAction();

        System.out.println("---------------------");
        System.out.println("3."); //третье задание
        Triangle triangle = new Triangle("Треугольник");
        Circle circle = new Circle("Круг");
        Canvas canvas = new Canvas();
        System.out.println(canvas);
        canvas.draw(triangle);
        canvas.draw(circle);
        System.out.println(canvas);
        canvas.eraseAll();
        System.out.println(canvas);

        Oval oval = new Oval("Овал");
        canvas.draw(oval);
        System.out.println(canvas);

        HashMap<String, String> map = new HashMap<>();

    }


    /*
Пример работы программы:
---------------------
1.
First name: Alexey, middle name: Andreev, last name: Vladimirovich, country: Russia, address: Laplandia, phone: нет данных, age: 37, gender: нет данных
---------------------
2.
First car
Car is open
Engine start
Car is moving
Car is stop
Engine stop
---------------------
Second car
Engine start
Car is moving
Car is stop
Engine stop
---------------------
3.
Чистая доска
Рисую на доске Треугольник
Рисую на доске Круг
На доске нарисованы:
Треугольник;
Круг;
Очищаю доску
Чистая доска
     */
}
