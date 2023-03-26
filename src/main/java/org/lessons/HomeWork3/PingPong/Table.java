package org.lessons.HomeWork3.PingPong;

public class Table {
    private static volatile boolean pongSide;
    private static volatile boolean pingSide;
    private static final Table table;

    static {
        table = new Table();
    }

    private Table() {
        pongSide = true;
    }

    public synchronized static Table getTable() {
        return table;
    }

    public synchronized int action(Racket racket) {
        if (pongSide && racket instanceof Pong) {
            racket.kick();
            pongSide = false;
            pingSide = true;
            return 1;
        } else if (pingSide && racket instanceof Ping) {
            racket.kick();
            pongSide = true;
            pingSide = false;
            return 1;
        } else {
            return 0;
        }
    }
}
