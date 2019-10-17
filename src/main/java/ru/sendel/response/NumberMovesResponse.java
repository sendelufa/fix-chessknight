package ru.sendel.response;

public class NumberMovesResponse implements IBodyResponse {

   private int moves;

   public NumberMovesResponse(int moves) {
      this.moves = moves;
   }

   @Override
   public Integer getBody() {
      return moves;
   }

   public int getMoves() {
      return moves;
   }

   public void setMoves(int moves) {
      this.moves = moves;
   }
}
