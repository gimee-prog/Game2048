package ru.ais;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game2048 implements Game {
    GameHelper helper = new GameHelper();
    public static final int GAME_SIZE = 4;
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);

    Random random = new Random();

   // public Game2048(Board board) {
   //     this.board = board;
   // }

    @Override
    public void init() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < GAME_SIZE*GAME_SIZE; i++) {
            list.add(null);
        }
        board.fillBoard(list);
        addItem();
        addItem();
    }

    @Override
    public boolean canMove() {
        return board.availableSpace().size() != 0;
    }

    @Override
    public boolean move(Direction direction) {
        return false;
    }

    @Override
    public void addItem() {
        if (board.availableSpace().size() != 0) {
            List<Key> emptyCells = new ArrayList<>();
            emptyCells= board.availableSpace();
            board.addItem(emptyCells.get(random.nextInt(emptyCells.size()+1)), random.nextBoolean() ? 2 : 4);
        }
    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }
}
