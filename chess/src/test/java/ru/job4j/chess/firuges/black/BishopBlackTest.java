package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void whePositionIsCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A3);
        assertThat((bishopBlack.position()), is(Cell.A3));
    }

    @Test
    public void whenCopyIsCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D1);
        assertThat(bishopBlack.copy(Cell.D1).position(), is(Cell.D1));
    }

    @Test
    public void whenWayIsCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5), is(expected));
    }
}