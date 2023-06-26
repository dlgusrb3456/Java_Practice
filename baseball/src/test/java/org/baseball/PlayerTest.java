package org.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

  private InputStream generateUserInputStream(String inputString) {
    return new ByteArrayInputStream(inputString.getBytes());
  }

  @Test
  @DisplayName("Player inputAnswer 테스트 - 성공")
  void inputAnswer_success() {
    Player player = new Player();

    InputStream inputStream = generateUserInputStream("123");
    System.setIn(inputStream);
    Scanner scanner = new Scanner(System.in);

    player.inputAnswer(scanner);

    assertEquals("123", player.getPlayerInput());
  }

  @Test
  @DisplayName("Player inputAnswer 테스트 - length 예외처리")
  void inputAsnwer_length_validation() {
    Player player = new Player();

    InputStream inputStream = generateUserInputStream("13");
    System.setIn(inputStream);
    Scanner scanner = new Scanner(System.in);

    assertThrows(IllegalArgumentException.class, () -> player.inputAnswer(scanner));
  }

  @Test
  @DisplayName("Player inputAnswer 테스트 - type 예외처리")
  void inputAsnwer_type_validation() {
    Player player = new Player();

    InputStream inputStream = generateUserInputStream("asd");
    System.setIn(inputStream);
    Scanner scanner = new Scanner(System.in);

    assertThrows(IllegalArgumentException.class, () -> player.inputAnswer(scanner));
  }
}