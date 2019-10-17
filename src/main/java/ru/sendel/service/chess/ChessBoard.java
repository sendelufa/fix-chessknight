package ru.sendel.service.chess;

import ru.sendel.dto.KnightMovesParams;

public class ChessBoard {

   private int[][] chessBoard;

   public ChessBoard(KnightMovesParams params) {
      chessBoard = new int[params.getWidth()][params.getHeight()];
   }

   public int[][] getChessBoard() {
      return chessBoard;
   }

   public int getCellValue(int x, int y) {
      if (isInputValid(x, y)) {
        return chessBoard[x][y];
      } else {
         return -1;
      }
   }

   public void setCellMovesValue(int x, int y, int moveNumber){
      if (isInputValid(x, y)) {
         chessBoard[x][y] = moveNumber;
      }
   }

   private boolean isInputValid(int x, int y) {
      return !(y > chessBoard.length || y < 1 || x > chessBoard[0].length || x < 1);
   }
}
