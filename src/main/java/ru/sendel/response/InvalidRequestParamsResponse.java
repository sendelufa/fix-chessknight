package ru.sendel.response;

public class InvalidRequestParamsResponse implements IBodyResponse {

   private String answer;

   public InvalidRequestParamsResponse(String answer) {
      this.answer = answer;
   }

   @Override
   public String getBody() {
      return answer;
   }

   public String getAnswer() {
      return answer;
   }

   public void setAnswer(String answer) {
      this.answer = answer;
   }
}
