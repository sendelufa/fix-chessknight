package ru.sendel.service.chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessKnight {

   private static final Logger LOGGER = LoggerFactory.getLogger(ChessKnight.class);
   private final KnightMovesParams params;
   private ChessBoard chessBoard;

   public ChessKnight(KnightMovesParams params) {
      this.params = params;
      chessBoard = new ChessBoard(params);
   }

   public int getMinMoves() {
      int moves = 0;
      if (params.getStart().equals(params.getEnd())) {
         return 0;
      }
      Set<CellBoard> walkedCells = new HashSet<>();
      walkedCells.add(params.getStart());
      List<CellBoard> nextMoves = new ArrayList<>(walkedCells);
      Set<CellBoard> currentMoves;
      while (!nextMoves.contains(params.getEnd())) {

         currentMoves = nextMoves.stream().map(this::getNextNotRepeatedKnightsTurns)
             .flatMap(Collection::stream)
             .filter(c -> c.getRow() > 0)
             .filter(c -> c.getColumn() > 0)
             .filter(c -> c.getRow() < params.getHeight())
             .filter(c -> c.getColumn() < params.getWidth())
             .filter(c -> !walkedCells.contains(c))
             .collect(Collectors.toSet());

         walkedCells.addAll(currentMoves);

         if (currentMoves.size() == 0) {
            break;
         }
         moves++;
         if (currentMoves.contains(params.getEnd())) {
            return moves;
         }

         nextMoves.clear();
         nextMoves.addAll(currentMoves);


      }
      return -1;
   }

   private List<CellBoard> getNextNotRepeatedKnightsTurns(CellBoard cell) {
      List<CellBoard> nextMoves = new ArrayList<>(8);
      nextMoves.add(cell.move(1, 2));
      nextMoves.add(cell.move(1, -2));
      nextMoves.add(cell.move(-1, -2));
      nextMoves.add(cell.move(-1, 2));
      nextMoves.add(cell.move(2, -1));
      nextMoves.add(cell.move(2, 1));
      nextMoves.add(cell.move(-2, -1));
      nextMoves.add(cell.move(-2, 1));
      return nextMoves;
   }
}
