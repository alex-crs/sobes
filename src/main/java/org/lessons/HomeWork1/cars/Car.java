package org.lessons.HomeWork1.cars;

public abstract class Car {
    private Engine engine; //заменил модификатор public (доступ осуществляется через get)
    private String color;
    private String name;
    protected void start() {
        System.out.println("Car starting");
    }
    abstract void open();

    public Engine getEngine() { //отсутствует двигатель... как так
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
