package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    @Test
    public void testUpdateStatus_X_Win() {
        TicTacToeModel tttm = new TicTacToeModel();
        tttm.play(0, 0); // X
        tttm.play(1, 1); // O
        tttm.play(0, 1); // X
        tttm.play(1, 2); // O
        tttm.play(0, 2); // X (X wins)
        assertEquals(TicTacToeModel.Status.X_WON, tttm.getStatus());
    }

    @Test
    public void testUpdateStatus_O_Win() {
        TicTacToeModel tttm = new TicTacToeModel();
        tttm.play(1, 1); // X
        tttm.play(0, 0); // O
        tttm.play(2, 1); // X
        tttm.play(0, 1); // O
        tttm.play(2, 2); // X
        tttm.play(0, 2); // O (O wins)
        assertEquals(TicTacToeModel.Status.O_WON, tttm.getStatus());
    }

    @Test
    public void testUpdateStatus_Tie() {
        TicTacToeModel tttm = new TicTacToeModel();
        tttm.play(0, 0); //X
        tttm.play(1, 0); //O
        tttm.play(0, 1); //X
        tttm.play(1, 1); //O
        tttm.play(1, 2); //X
        tttm.play(0, 2); //O
        tttm.play(2, 0); //X
        tttm.play(2, 1); //O
        tttm.play(2, 2); //X (Tie)
        assertEquals(TicTacToeModel.Status.TIE, tttm.getStatus());
    }

    @Test
    public void testUpdateStatus_Undecided() {
        TicTacToeModel tttm = new TicTacToeModel();
        tttm.play(0, 0); // X
        assertEquals(TicTacToeModel.Status.UNDECIDED, tttm.getStatus());
    }
}
