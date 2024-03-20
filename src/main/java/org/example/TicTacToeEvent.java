package org.example;

import java.util.EventObject;

public class TicTacToeEvent extends EventObject {

    private int x;
    private int y;

    public TicTacToeEvent(TicTacToeModel source, int x, int y) {
        super(source);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
