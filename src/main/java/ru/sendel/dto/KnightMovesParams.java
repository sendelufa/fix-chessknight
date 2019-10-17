package ru.sendel.dto;

public class KnightMovesParams {

   private int width;
   private int height;
   private String start;
   private String end;

   public KnightMovesParams(int width, int height, String start, String end) {
      this.width = width;
      this.height = height;
      this.start = start;
      this.end = end;
   }

   public static KnightMovesParams getInstance(int width, int height, String start, String end){
      if (!isValidChessboardSize(width, height)){}

      return new KnightMovesParams(width, height, start, end);
   }

   public int getWidth() {
      return width;
   }

   public void setWidth(int width) {
      this.width = width;
   }

   public int getHeight() {
      return height;
   }

   public void setHeight(int height) {
      this.height = height;
   }

   public String getStart() {
      return start;
   }

   public void setStart(String start) {
      this.start = start;
   }

   public String getEnd() {
      return end;
   }

   public void setEnd(String end) {
      this.end = end;
   }

   private static boolean isValidChessboardSize(int width, int height){
      return width > 1;
   }
}
