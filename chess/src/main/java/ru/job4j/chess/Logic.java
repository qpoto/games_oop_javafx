package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        free(steps);
        figures[index] = figures[index].copy(dest);
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
        Cell dest = steps[steps.length - 1];
        for (int i = 0; i < steps.length; i++) {
            Cell source = steps[i];
            Figure figure = figures[findBy(source)];
            if (figure != null) {
                Cell[] figureWay = figure.way(dest);
                for (int j = 0; j < figureWay.length; j++) {
                    if(figureWay[i] != null) {
                        break;
                    }
                }
                figures[findBy(source)] = figure.copy();
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException("Figure not found on the board.");
    }
}
