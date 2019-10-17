package ru.sendel.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.sendel.dto.KnightMovesParams;
import ru.sendel.response.IBodyResponse;
import ru.sendel.response.NumberMovesResponse;
import ru.sendel.service.chess.ChessKnight;

@Service
@Component("knightChessService")
public class KnightChessService implements IKnightService{

   @Override
   public IBodyResponse calculateKnightsMoves(KnightMovesParams knightMovesParams){
      ChessKnight chessKnight = new ChessKnight(knightMovesParams);

      return new NumberMovesResponse(chessKnight.getMinMoves());
   }

}
