package ru.sendel.service;

import ru.sendel.dto.KnightMovesParams;
import ru.sendel.response.IBodyResponse;

public interface IKnightService {
   IBodyResponse calculateKnightsMoves(KnightMovesParams knightMovesParams);
}
