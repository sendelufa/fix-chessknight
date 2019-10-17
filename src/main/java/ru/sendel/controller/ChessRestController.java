package ru.sendel.controller;


import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/")
public class ChessRestController {

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
       @RequestParam(value = "width") Integer width,
       @RequestParam(value = "height") Integer height,
       @RequestParam(value = "start") String startCell,
       @RequestParam(value = "end") String endCell) {
      LOGGER.info("request:width: {}, width: {}, width: {}, width: {}",
          width, height, startCell, endCell);
      return new ResponseEntity<>(String.format("width: %s, width: %s, width: %s, width: %s",
          width, height, startCell, endCell),
          HttpStatus.OK);
   }
}
