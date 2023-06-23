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
}
