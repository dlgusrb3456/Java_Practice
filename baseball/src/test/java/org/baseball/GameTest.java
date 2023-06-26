package org.baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

  private InputStream createInputStream(List<String> lists) {
    List<InputStream> streams = lists.stream()
        .map(string -> new ByteArrayInputStream(string.getBytes())).collect(
            Collectors.toList());
    return new SequenceInputStream(Collections.enumeration(streams));
  }

  @Test
  @DisplayName("Game run 테스트 2 Return- 성공")
  void run_success_return_2() {
    Game game = new Game();
    Computer computer = new Computer();
    Player player = new Player();
    computer.setAnswer("123");

    try {
      Method method = game.getClass()
          .getDeclaredMethod("run", Computer.class, Player.class, Scanner.class);
      method.setAccessible(true);

      List<String> lists = new ArrayList<>(Arrays.asList("124\n", "123\n", "2"));

      System.setIn(createInputStream(lists));
      Scanner scanner = new Scanner(System.in);

      String result = (String) method.invoke(game, computer, player, scanner);
      assertEquals("2", result);
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException exception) {
      exception.printStackTrace();
    }
  }

  @Test
  @DisplayName("Game run 테스트 1 Return- 성공")
  void run_success_return_1() {
    Game game = new Game();
    Computer computer = new Computer();
    Player player = new Player();
    computer.setAnswer("123");

    try {
      Method method = game.getClass()
          .getDeclaredMethod("run", Computer.class, Player.class, Scanner.class);
      method.setAccessible(true);

      List<String> lists = new ArrayList<>(Arrays.asList("123\n", "1"));

      System.setIn(createInputStream(lists));
      Scanner scanner = new Scanner(System.in);

      String result = (String) method.invoke(game, computer, player, scanner);
      assertEquals("1", result);
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException exception) {
      exception.printStackTrace();
    }
  }

  @Test
  @DisplayName("Game run 테스트 1 Return- 성공")
  void run_exception_one_or_two_validation() {
    Game game = new Game();
    Computer computer = new Computer();
    Player player = new Player();
    computer.setAnswer("123");

    try {
      Method method = game.getClass()
          .getDeclaredMethod("run", Computer.class, Player.class, Scanner.class);
      method.setAccessible(true);
      List<String> lists = new ArrayList<>(Arrays.asList("123\n", "3"));

      System.setIn(createInputStream(lists));
      Scanner scanner = new Scanner(System.in);
      
      assertThrows(InvocationTargetException.class,
          () -> method.invoke(game, computer, player, scanner));

    } catch (NoSuchMethodException exception) {
      exception.printStackTrace();
    }
  }
}