package ru.sendel.service;

import ru.sendel.service.chess.KnightMovesParams;
import ru.sendel.response.IBodyResponse;

public interface IKnightService {
   IBodyResponse calculateKnightsMoves(KnightMovesParams knightMovesParams);
}
