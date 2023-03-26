package org.lessons.HomeWork3.PingPong;

public class Gamer{
    private final Table table;
    private final Racket racket;

    public Gamer(Table table, Racket racket) {
        this.table = table;
        this.racket = racket;
    }

    public void action(){
        table.action(racket);
    }
}
