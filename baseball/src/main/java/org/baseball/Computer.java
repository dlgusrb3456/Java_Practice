package org.baseball;

import java.util.Random;

public class Computer {

  private String answer;

  public Computer() {
  }

  public void calculateAnswer() {
    Random random = new Random();
    String stringAnswer = "";
    while (stringAnswer.length() != 3) {
      String tempAnswer = String.valueOf(random.nextInt(9) + 1);
      if (!stringAnswer.contains(tempAnswer)) {
        stringAnswer += tempAnswer;
      }
    }

    this.answer = stringAnswer;
  }

  public Result checkAnswer(String playerAnswer) {
    return checkAnswer(playerAnswer, this.answer);
  }

  private Result checkAnswer(String playerAnswer, String computerAnswer) {
    int ball = 0;
    int strike = 0;

    for (int i = 0; i < 3; i++) {
      char checkChar = playerAnswer.charAt(i);
      if (checkChar == computerAnswer.charAt(i)) {
        strike += 1;
        continue;
      }

      if (computerAnswer.contains(String.valueOf(checkChar))) {
        ball += 1;
      }
    }
    return Result.of(ball, strike);
  }

  public String getAnswer() {
    return this.answer;
  }
}