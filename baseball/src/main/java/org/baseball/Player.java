package org.baseball;

import java.util.Scanner;

public class Player {

  private String playerInput;

  public Player() {
  }

  public void inputAnswer(Scanner scanner) {
    System.out.print("숫자를 입력해주세요 : ");
    this.playerInput = scanner.next();

    validateIsInt(this.playerInput);
    validateLength(this.playerInput);
  }

  private void validateIsInt(String playerInput) {
    try {
      Integer.valueOf(playerInput);
    } catch (NumberFormatException exception) {
      throw new IllegalArgumentException();
    }
  }

  private void validateLength(String playerInput) {
    if (playerInput.length() != 3) {
      throw new IllegalArgumentException();
    }
  }

  public String getPlayerInput() {
    return this.playerInput;
  }
}
