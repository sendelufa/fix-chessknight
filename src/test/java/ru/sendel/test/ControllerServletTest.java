package ru.sendel.test;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.sendel.controller.servlet.ChessServletController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class ControllerServletTest extends Mockito {

   @Value("${knightmoves.request.param.width}")
   private String widthName;
   @Value("${knightmoves.request.param.height}")
   private String heightName;
   @Value("${knightmoves.request.param.start}")
   private String startName;
   @Value("${knightmoves.request.param.end}")
   private String endName;

   private StringWriter stringWriter = new StringWriter();
   private PrintWriter writer = new PrintWriter(stringWriter);

   private HttpServletRequest request = mock(HttpServletRequest.class);
   private HttpServletResponse response = mock(HttpServletResponse.class);

   @Test
   public void test_ServletResponse_BadRequest_wo_params() throws Exception {
      when(response.getWriter()).thenReturn(writer);

      new ChessServletController().doGet(request, response);
      writer.flush();

      Assert.assertEquals("error. not valid input params", stringWriter.toString());
   }

   @Test
   public void test_Servlet_RequestedParams() throws Exception {
      when(request.getParameter(widthName)).thenReturn("10");
      when(request.getParameter(heightName)).thenReturn("14");
      when(request.getParameter(startName)).thenReturn("F1");
      when(request.getParameter(endName)).thenReturn("C4");

      when(response.getWriter()).thenReturn(writer);
      new ChessServletController().doGet(request, response);

      verify(request, atLeast(1)).getParameter(widthName);
      verify(request, atLeast(1)).getParameter(heightName);
      verify(request, atLeast(1)).getParameter(startName);
      verify(request, atLeast(1)).getParameter(endName);
      writer.flush();
   }

   @Test
   public void test_ServletResponse_OneMove() throws Exception {
      when(request.getParameter(widthName)).thenReturn("10");
      when(request.getParameter(heightName)).thenReturn("14");
      when(request.getParameter(startName)).thenReturn("B1");
      when(request.getParameter(endName)).thenReturn("A3");

      when(response.getWriter()).thenReturn(writer);
      new ChessServletController().doGet(request, response);
      writer.flush();

      Assert.assertEquals("1", stringWriter.toString());

   }
}
