package snake_and_ladder;

import java.util.HashMap;

public class Board {
    int                           dimension;
    HashMap<Integer, BoardEntity> boardEntities;

    public Board(int dimension) {
        this.dimension = dimension;
        this.boardEntities = new HashMap<>();
    }

    public void printBoard() {
        int totalCells = dimension * dimension;
        for (int i = totalCells; i > 0; i--) {
            System.out.print(" | " + i + " ");

            if (hasBoardEntity(i)) {
                System.out.print(boardEntities.get(i).getId());
            }
            System.out.print(" |");
            if (totalCells % 10 == 0) {System.out.println();}
        }
    }

    public int getTotalCells() {
        return this.dimension * this.dimension;
    }

    public void addBoardEntity(BoardEntity entity) {
        int startPosition = entity.getStartPosition();
        boardEntities.put(startPosition, entity);
    }

    public boolean hasBoardEntity(int position) {
        return boardEntities.containsKey(position);
    }

    public BoardEntity getBoardEntity(int position) {
        if (hasBoardEntity(position)) {
            return boardEntities.get(position);
        }
        return null;
    }
}
