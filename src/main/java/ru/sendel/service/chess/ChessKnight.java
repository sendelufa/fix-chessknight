package ru.sendel.service.chess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sendel.dto.KnightMovesParams;

public class ChessKnight {
   private final KnightMovesParams params;
   private ChessBoard chessBoard;
   private static final Logger LOGGER = LoggerFactory.getLogger(ChessKnight.class);
   public ChessKnight(KnightMovesParams params) {
      this.params = params;
      LOGGER.info(params.getStart());
      chessBoard = new ChessBoard(params);
      LOGGER.info(params.getEnd());
   }

   public int getMinMoves(){
      return 0;
   }
}
