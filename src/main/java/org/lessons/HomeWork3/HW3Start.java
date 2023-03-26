package org.lessons.HomeWork3;

import org.lessons.HomeWork3.Count.Count;
import org.lessons.HomeWork3.PingPong.*;

public class HW3Start {
    public static void main(String[] args) {
        Count count = new Count();
        Thread gamer1 = getGamer(new Pong(), count);
        Thread gamer2 = getGamer(new Ping(), count);
        System.out.println("Игра началась!");
        gamer1.start();
        gamer2.start();
        try {
            gamer1.join();
            gamer2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Количество действий = " + count.getCount());
    }

    static Thread getGamer(Racket racket, Count count) {
        return new Thread(() -> {
            while (count.getCount() < 10) {
                Table.getTable().action(racket);
                count.countUp();
            }
        });
    }
}

/*Вывод в консоль:
        Игра началась!
        Понг
        Пинг
        Понг
        Пинг
        Понг
        Пинг
        Понг
        Пинг
        Понг
        Пинг
        Понг
        Количество действий = 11*/