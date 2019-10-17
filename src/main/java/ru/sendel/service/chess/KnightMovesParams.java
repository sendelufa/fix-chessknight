package ru.sendel.service.chess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.sendel.exception.NotValidChessBoardCellName;
import ru.sendel.exception.NotValidChessBoardSize;

@Component
public class KnightMovesParams {

   private static final int ALPHABET_SIZE = 26;
   private static final int OFFSET_A_CODE = 96;
   private static int MAX_BOARD_SIZE;
   private final int width;
   private final int height;
   private final CellBoard start;
   private final CellBoard end;

   private KnightMovesParams() {
      width = 0;
      height = 0;
      start = null;
      end = null;

   }

   private KnightMovesParams(int width, int height, CellBoard start, CellBoard end) {
      this.width = width;
      this.height = height;
      this.start = start;
      this.end = end;
   }

   public static KnightMovesParams getInstance(
       int width, int height, String startCell, String endCell) {

      if (!isValidChessboardSize(width, height)) {
         throw new NotValidChessBoardSize();
      }

      CellBoard start = convertToCell(startCell);
      CellBoard end = convertToCell(endCell);

      if (start.getColumn() > width || end.getColumn() > width || start.getRow() > height
          || end.getRow() > height) {
         throw new NotValidChessBoardSize();
      }
      return new KnightMovesParams(width, height, start, end);
   }

   private static boolean isValidChessboardSize(int width, int height) {
      return width > 1 && width <= MAX_BOARD_SIZE && height > 1 && height <= MAX_BOARD_SIZE;
   }

   private static CellBoard convertToCell(String cellName) {
      Matcher cellMatcher = Pattern.compile(RegexCellName.REGEX_CELLNAME).matcher(cellName);
      if (!cellMatcher.find()) {
         throw new NotValidChessBoardCellName();
      }
      int column = convertLettersToInt(cellMatcher.group(RegexCellName.COLUMN_GROUP));
      int row = Integer.parseInt(cellMatcher.group(RegexCellName.ROW_GROUP));
      return new CellBoard(column, row);
   }

   private static int convertLettersToInt(String columnName) {
      char[] letters = columnName.toLowerCase().toCharArray();
      int columnNumber = 0;
      for (int i = 0; i < letters.length; i++) {
         columnNumber += //UTF-8 a-z
             (letters[i] - OFFSET_A_CODE) * Math.pow(ALPHABET_SIZE, letters.length - i - 1);

      }
      return columnNumber;
   }

   @Autowired
   public void setMaxBoardSize(@Value("${chess.chessboard.maxsize:1000}") int max) {
      MAX_BOARD_SIZE = max;
   }

   public int getWidth() {
      return width;
   }

   public int getHeight() {
      return height;
   }


   public CellBoard getStart() {
      return start;
   }

   public CellBoard getEnd() {
      return end;
   }

   @Override
   public String toString() {
      return String.format("%s width: %d, height: %d, start: %s, end: %s",
          this.getClass().getCanonicalName(), width, height, start, end);
   }
}

class RegexCellName {

   final static String COLUMN_GROUP = "column";
   final static String ROW_GROUP = "row";
   final static String REGEX_CELLNAME = String.format("(?<%s>\\w+)(?<%s>\\d+)",
       COLUMN_GROUP, ROW_GROUP);
}
