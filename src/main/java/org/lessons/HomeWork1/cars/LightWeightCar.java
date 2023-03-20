package org.lessons.HomeWork1.cars;

public class LightWeightCar extends Car implements Movable, Stopable { //отсутствовала реализация интерфейса Stopable,
    //управлять машиной без тормозов запрещено:)

    public LightWeightCar() { //добавил конструктор с инициализацией двигателя
        this.setEngine(new Engine());
    }

    @Override
    public void open() { //добавил модификатор public (иначе за пределами пакета не будет доступа к методу)
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override //отсутствовало переопределение метода
    public void stop(){
        System.out.println("Car is stop");
    }
}
