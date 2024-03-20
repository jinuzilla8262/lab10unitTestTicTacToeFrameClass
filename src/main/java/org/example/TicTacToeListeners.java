package org.example;

public interface TicTacToeListeners {
    void onMoveMade(TicTacToeEvent e);
    void onGameStatusUpdate(TicTacToeModel.Status status);
}
