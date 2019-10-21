package ru.sendel.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.sendel.exception.NotValidChessBoardSize;
import ru.sendel.response.IBodyResponse;
import ru.sendel.service.IKnightService;
import ru.sendel.service.KnightChessService;
import ru.sendel.service.chess.KnightMovesParams;

@Component
public class ChessServletController extends HttpServlet {

   private final String widthName = "width";
   private final String heightName = "height";
   private final String startName = "start";
   private final String endName = "end";

   private IKnightService knightChessService = new KnightChessService();
   private IBodyResponse response;

   private int widthChessBoard;
   private int heightChessBoard;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
       throws ServletException, IOException {
      resp.setContentType("text/plain");
      try (PrintWriter out = resp.getWriter()) {
         try {
            widthChessBoard = Integer.parseInt(req.getParameter(widthName));
            heightChessBoard = Integer.parseInt(req.getParameter(heightName));

            response = knightChessService.calculateKnightsMoves(
                KnightMovesParams.getInstance(widthChessBoard,
                    heightChessBoard, req.getParameter(startName), req.getParameter(endName)));

         } catch (NotValidChessBoardSize | NumberFormatException e) {
            resp.setStatus(400);
            out.write("error. not valid input params");
            return;
         }
         out.write(response.getBody().toString());
      }
   }
}
