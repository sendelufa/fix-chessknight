package ru.sendel.test;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sendel.service.chess.ChessKnight;
import ru.sendel.service.chess.KnightMovesParams;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgorithmTest extends TestCase {


   @Test
   public void test_one_move() {
      KnightMovesParams kmpOneMove =
          KnightMovesParams.getInstance(10, 14, "B1", "A3");
      int actual = new ChessKnight(kmpOneMove).getMinMoves();
      assertEquals(1, actual);
   }

   @Test
   public void test_five_moves() {
      KnightMovesParams kmpFiveMoves =
          KnightMovesParams.getInstance(11, 6, "A2", "I5");
      int actual = new ChessKnight(kmpFiveMoves).getMinMoves();
      assertEquals(5, actual);
   }

   @Test
   public void test_zero_move() {
      KnightMovesParams kmpZeroMove =
          KnightMovesParams.getInstance(2, 2, "A1", "A1");
      int actual = new ChessKnight(kmpZeroMove).getMinMoves();
      assertEquals(0, actual);
   }

   @Test
   public void test_no_moves() {
      KnightMovesParams kmpNoMoves =
          KnightMovesParams.getInstance(2, 2, "A1", "A2");
      int actual = new ChessKnight(kmpNoMoves).getMinMoves();
      assertEquals(-1, actual);
   }
}
