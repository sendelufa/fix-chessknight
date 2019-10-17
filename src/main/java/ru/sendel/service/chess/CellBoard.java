package ru.sendel.service.chess;

public class CellBoard {

   private final int column;
   private final int row;

   public CellBoard(int column, int row) {
      this.column = column;
      this.row = row;
   }

   public int getColumn() {
      return column;
   }

   public int getRow() {
      return row;
   }

   @Override
   public int hashCode() {
      return column + row;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      CellBoard other = (CellBoard) obj;
      return column == other.getColumn() && row == other.getRow();
   }

   @Override
   public String toString() {
      return String.format("[%d:%d]", column, row);
   }

   public CellBoard move(int columns, int rows) {
      return new CellBoard(column + columns, row + rows);
   }
}
