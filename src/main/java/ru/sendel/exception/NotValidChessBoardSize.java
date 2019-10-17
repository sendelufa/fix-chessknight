package ru.sendel.exception;

public class NotValidChessBoardSize extends RuntimeException {

   public NotValidChessBoardSize() {
      super("Not valid width or height of chessboard");
   }
}
