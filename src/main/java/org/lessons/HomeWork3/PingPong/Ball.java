package org.lessons.HomeWork3.PingPong;

public class Ball {
    private static volatile boolean pongSide;
    private static volatile boolean pingSide;
    private static final Ball ball;

    static {
        ball = new Ball();
    }

    private Ball() {
        pongSide = true;
    }

    public synchronized static Ball getBall() {
        return ball;
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
