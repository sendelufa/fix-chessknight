package ru.sendel.service.chess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessKnight {
   private final KnightMovesParams params;
   private ChessBoard chessBoard;
   private static final Logger LOGGER = LoggerFactory.getLogger(ChessKnight.class);
   public ChessKnight(KnightMovesParams params) {
      this.params = params;
      chessBoard = new ChessBoard(params);
   }

   public int getMinMoves(){
      return 0;
   }
}
