package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
public class TicTacToeFrameTest {
    @Test
    public void testTicTacToeFrameInstantiation() {
        TicTacToeModel stubModel = mock(TicTacToeModel.class);
        TicTacToeFrame frame = new TicTacToeFrame(stubModel);
        assertEquals("TicTacToe", frame.getTitle());
    }

}
