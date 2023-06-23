package org.baseball;

import java.util.Random;

public class Main {

  private static String answer;

  public static void main(String[] args) {

    answer = setAnswer();
  }

  private static String setAnswer() {
    Random random = new Random();
    String stringAnswer = "";
    while (stringAnswer.length() != 3) {
      String tempAnswer = String.valueOf(random.nextInt(9) + 1);
      if (!stringAnswer.contains(tempAnswer)) {
        stringAnswer += tempAnswer;
      }
    }

    return stringAnswer;
  }
}