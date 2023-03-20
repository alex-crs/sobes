package org.lessons.HomeWork1.cars;

public class Engine {
    boolean isWork; //добавил состояние двигателя

    public void engineAction() { //запустим двигатель:)
        if (!isWork) {
            isWork = true;
            System.out.println("Engine start");
        } else {
            isWork = false;
            System.out.println("Engine stop");
        }
    }
}
