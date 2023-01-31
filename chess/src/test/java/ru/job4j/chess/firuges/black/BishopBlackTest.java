package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;

import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        bishopBlack.position();
    }

    @Test
    void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        bishopBlack.copy(Cell.C3);
    }

    @Test
    void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] rsl = bishopBlack.way(Cell.G5);
        Cell[] exp = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(exp, rsl);
    }
}