package snake_and_ladder;

import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws GameAlreadyStartedException {
        BoardEntity snake1 = new Snake(28, 12);
        BoardEntity snake2 = new Snake(78, 34);
        BoardEntity snake3 = new Snake(69, 6);
        BoardEntity snake4 = new Snake(84, 65);

        BoardEntity ladder1 = new Ladder(24, 56);
        BoardEntity ladder2 = new Ladder(43, 83);
        BoardEntity ladder3 = new Ladder(3, 31);
        BoardEntity ladder4 = new Ladder(72, 91);

        Board board = new Board(10);
        board.addBoardEntity(snake1);
        board.addBoardEntity(snake2);
        board.addBoardEntity(snake3);
        board.addBoardEntity(snake4);

        board.addBoardEntity(ladder1);
        board.addBoardEntity(ladder2);
        board.addBoardEntity(ladder3);
        board.addBoardEntity(ladder4);

        Dice dice = new Dice(6);

        Game game = new Game(board, dice);

        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        Player player3 = new Player("p3", 0);

        List<Player> players = Arrays.asList(player1, player2, player3);
        game.addPlayers(players);
        game.startGame();
    }
}
