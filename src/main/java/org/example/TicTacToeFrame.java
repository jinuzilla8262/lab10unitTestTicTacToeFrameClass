package org.example;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

import static org.example.TicTacToeModel.SIZE;
@Component
public class TicTacToeFrame extends JFrame implements TicTacToeListeners {

    private JButton[][] buttonGrid;

    public TicTacToeFrame(TicTacToeModel tttm) {
        super("TicTacToe");
     //  TicTacToeModel tttm = new TicTacToeModel();
        tttm.addTicTacToeListener(this);

        buttonGrid = new JButton[SIZE][SIZE];
        setupFrame();



        this.setLayout(new GridLayout(SIZE, SIZE));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton jb = new JButton("");
                buttonGrid[i][j] = jb;
                this.add(jb);
                jb.addActionListener(new TicTacToeButtonController(tttm, i, j));
            }
        }
    }

    private void setupFrame() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void onMoveMade(TicTacToeEvent e) {
        int x = e.getX();
        int y = e.getY();
        TicTacToeModel source = (TicTacToeModel) e.getSource();
        char label = source.getTurn() ? 'O' : 'X';
        buttonGrid[x][y].setText(Character.toString(label));
    }

    @Override
    public void onGameStatusUpdate(TicTacToeModel.Status status) {
        if (status == TicTacToeModel.Status.X_WON || status == TicTacToeModel.Status.O_WON || status == TicTacToeModel.Status.TIE) {
            showWinnerPopup(status);
        }
    }

    private void showWinnerPopup(TicTacToeModel.Status status) {
        String message;
        switch (status) {
            case X_WON:
                message = "Player X wins!";
                break;
            case O_WON:
                message = "Player O wins!";
                break;
            case TIE:
                message = "It's a tie!";
                break;
            default:
                message = "Unknown status";
                break;
        }
        JOptionPane.showMessageDialog(this, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}


