package org.baseball;

import java.util.Random;

public class Computer {

  private String answer;

  public Computer() {
  }

  public void calcAnswer() {
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

  public Answer checkAnswer(String playerAnswer) {
    int ball = 0;
    int strike = 0;

    for (int i = 0; i < 3; i++) {
      char checkChar = playerAnswer.charAt(i);
      if (checkChar == answer.charAt(i)) {
        strike += 1;
        continue;
      }

      if (answer.contains(String.valueOf(checkChar))) {
        ball += 1;
      }
    }

    return Answer.of(ball, strike);
  }
}