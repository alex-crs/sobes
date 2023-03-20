package org.lessons.HomeWork1.cars;

public class Lorry extends Car implements Movable, Stopable{ //отсутствовало реализация (implements) интерфейсов

    public Lorry() { //добавил конструктор с инициализацией двигателя
        this.setEngine(new Engine());
    }

    @Override //отсутствовала аннотация переопределения метода
    public void move(){
        System.out.println("Car is moving");
    }

    @Override //отсутствовала аннотация переопределения метода
    public void stop(){
        System.out.println("Car is stop");
    }

    @Override //не переопределен абстрактный метод
    void open() {
        System.out.println("Car is open");
    }
}
