package ru.sendel.exception;

public class NotValidChessBoardCellName extends RuntimeException {

   public NotValidChessBoardCellName() {
      super("Not valid cell name");
   }
}
