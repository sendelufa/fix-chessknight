package ru.sendel.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sendel.exception.NotValidChessBoardCellName;
import ru.sendel.exception.NotValidChessBoardSize;
import ru.sendel.service.KnightChessService;
import ru.sendel.service.chess.KnightMovesParams;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KnightMovesParamsTest {

   @Autowired
   private KnightChessService knightChessService;

   @Test(expected = NotValidChessBoardSize.class)
   public void test_set_params_all_valid() {
      KnightMovesParams kmp = KnightMovesParams.getInstance(1, 1, "A1", "A2");
      assertNotNull(kmp);
   }

   @Test(expected = NotValidChessBoardSize.class)
   public void test_set_params_not_valid_width() {
      KnightMovesParams.getInstance(-1, 1000, "A1", "A2");
   }

   @Test(expected = NotValidChessBoardSize.class)
   public void test_set_params_not_valid_height() {
      KnightMovesParams.getInstance(1000, -200, "A1", "A2");
   }

   @Test(expected = NotValidChessBoardSize.class)
   public void test_set_params_all_invalid() {
      KnightMovesParams.getInstance(-35, -200, "sdfs", "wwer33");
   }

   @Test(expected = NotValidChessBoardCellName.class)
   public void test_set_params_not_valid_start() {
      KnightMovesParams.getInstance(1000, 200, "DD", "A2");
   }

   @Test(expected = NotValidChessBoardCellName.class)
   public void test_set_params_not_valid_end() {
      KnightMovesParams.getInstance(1000, 200, "S2", "AF");
   }
}
