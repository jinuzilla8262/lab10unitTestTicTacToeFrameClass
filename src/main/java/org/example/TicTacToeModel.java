package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TicTacToeModel {

    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED}

    private char[][] grid;
    private boolean turn;
    private Status status;

    private List<TicTacToeListeners> ticTacToeListeners;

    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;
        ticTacToeListeners = new ArrayList<>();
    }

    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {
        return status;
    }

    private void updateStatus() {
        // Check rows, columns, and diagonals for winning conditions
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != ' ') {
                setStatus(grid[i][0]);
                return;
            }
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != ' ') {
                setStatus(grid[0][i]);
                return;
            }
        }
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' ') {
            setStatus(grid[0][0]);
            return;
        }
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != ' ') {
            setStatus(grid[0][2]);
            return;
        }
        // Check for a tie
        boolean tie = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == ' ') {
                    tie = false;
                    break;
                }
            }
        }
        if (tie) {
            status = Status.TIE;
            notifyListeners();
        }
    }

    private void setStatus(char winner) {
        if (winner == 'X') {
            status = Status.X_WON;
        } else {
            status = Status.O_WON;
        }
        notifyListeners();
    }

    private void notifyListeners() {
        for (TicTacToeListeners listener : ticTacToeListeners) {
            listener.onGameStatusUpdate(status);
        }
    }

    public boolean getTurn() {
        return turn;
    }

    public void addTicTacToeListener(TicTacToeListeners listener) {
        ticTacToeListeners.add(listener);
    }

    public void play(int x, int y) {
        if (grid[x][y] != ' ' || status != Status.UNDECIDED) return;
        grid[x][y] = turn ? 'X' : 'O';
        updateStatus();
        changeTurn();
        TicTacToeEvent event = new TicTacToeEvent(this, x, y);
        notifyMoveMade(event);
    }

    private void notifyMoveMade(TicTacToeEvent event) {
        for (TicTacToeListeners listener : ticTacToeListeners) {
            listener.onMoveMade(event);
        }
    }
}
