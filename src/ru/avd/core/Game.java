package ru.avd.core;


import ru.avd.core.Board;
import ru.avd.core.Direction;

public interface Game {
    void init();
    boolean canMove();
    boolean move(Direction direction);
    void addItem();
    Board getGameBoard();
    boolean hasWin();

}
