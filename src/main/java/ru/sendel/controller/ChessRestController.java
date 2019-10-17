package ru.sendel.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sendel.service.chess.KnightMovesParams;
import ru.sendel.response.IBodyResponse;
import ru.sendel.service.IKnightService;

@RestController
@RequestMapping("rest/")
public class ChessRestController {

   @Autowired
   private IKnightService knightChessService;

   private static final Logger LOGGER = LoggerFactory.getLogger(ChessRestController.class);

   /**
    * Get minimum number of chess knight moves
    *
    * @param width - width of field
    * @param height - height of field
    * @param startCell - cell where knight is start moves
    * @param endCell - cell where knight wants to move
    */
   @GetMapping("count")
   public ResponseEntity registration(
       @RequestParam(value = "width") int width,
       @RequestParam(value = "height") int height,
       @RequestParam(value = "start") String startCell,
       @RequestParam(value = "end") String endCell) {
      LOGGER.info("request:width: {}, width: {}, width: {}, width: {}",
          width, height, startCell, endCell);

      IBodyResponse response = knightChessService.calculateKnightsMoves(KnightMovesParams.getInstance(width,
          height, startCell, endCell));

      return new ResponseEntity<>(response.getBody(),
          HttpStatus.OK);
   }
}
