package org.baseball;

import java.util.Scanner;

public class Player {

  public Player() {
  }

  public String inputAnswer() {
    String playerInput;
    Scanner scanner = new Scanner(System.in);
    System.out.print("숫자를 입력해주세요 : ");
    playerInput = scanner.next();

    validateIsInt(playerInput);
    validateLength(playerInput);

    return playerInput;
  }

  private void validateIsInt(String playerInput) {
    try {
      Integer.valueOf(playerInput);
    } catch (IllegalArgumentException exception) {
      exception.printStackTrace();
    }
  }

  private void validateLength(String playerInput) {
    if (playerInput.length() != 3) {
      throw new IllegalArgumentException();
    }
  }
}
