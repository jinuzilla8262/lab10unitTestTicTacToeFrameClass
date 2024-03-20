package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeButtonController implements ActionListener {

    private int i, j;
    private TicTacToeModel tttm;

    public TicTacToeButtonController(TicTacToeModel tttm, int i, int j) {
        this.tttm = tttm;
        this.i = i;
        this.j = j;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tttm.play(i, j);
    }
}