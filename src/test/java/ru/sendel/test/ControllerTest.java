package ru.sendel.test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import ru.sendel.controller.rest.ChessRestController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

   private final String PATH_TEST_GET = "/rest/";
   private final String PATH_KNIGHT_MOVES_CALC = "/rest/count";
   @Autowired
   private ChessRestController controller;
   @Autowired
   private MockMvc mvc;

   @Value("${knightmoves.request.param.width}")
   private String widthName;
   @Value("${knightmoves.request.param.height}")
   private String heightName;
   @Value("${knightmoves.request.param.start}")
   private String startName;
   @Value("${knightmoves.request.param.end}")
   private String endName;

   @Test
   public void testResponseFormat() throws Exception {
      mvc.perform(get(PATH_TEST_GET))
          .andDo(print())
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("test")));
   }

   @Test
   public void test_Response_BadRequest_wo_params() throws Exception {
      mvc.perform(get(PATH_KNIGHT_MOVES_CALC))
          .andDo(print())
          .andExpect(status().isBadRequest());
   }

   @Test
   public void test_Response_OneMove() throws Exception {
      mvc.perform(get(PATH_KNIGHT_MOVES_CALC)
          .param(widthName, "10")
          .param(heightName, "14")
          .param(startName, "B1")
          .param(endName, "A3"))
          .andDo(print())
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("1")));
   }

   @Test
   public void test_Response_BadRequest_wo_end() throws Exception {
      mvc.perform(get(PATH_KNIGHT_MOVES_CALC)
          .param(widthName, "10")
          .param(heightName, "14")
          .param(startName, "B1"))
          .andDo(print())
          .andExpect(status().isBadRequest());
   }

}
