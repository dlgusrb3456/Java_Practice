package org.baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {


  @Test
  @DisplayName("Computer 생성자 테스트")
  void makeComputer() {
    Computer computer = new Computer();
    assertNotNull(computer);
  }

  @Test
  @DisplayName("Computer calculateAnswer 테스트")
  void calculateAnswer() {
    Computer computer = new Computer();
    computer.calculateAnswer();
    String answer = computer.getAnswer();
    assertNotNull(answer);
    assertDoesNotThrow(() -> Integer.valueOf(answer));
    assertEquals(3, answer.length());
  }

  @Test
  @DisplayName("Computer checkAnswer 테스트")
  void checkAnswer() {
    Computer computer = new Computer();
    try {
      Method method = computer.getClass()
          .getDeclaredMethod("checkAnswer", String.class, String.class);
      method.setAccessible(true);

      Result result = (Result) method.invoke(computer, "123", "123");
      assertNotNull(result);
      assertEquals(3, result.getStrike());
      assertEquals(0, result.getBall());
      assertTrue(result.getCorrect());

      result = (Result) method.invoke(computer, "456", "123");
      assertNotNull(result);
      assertEquals(0, result.getStrike());
      assertEquals(0, result.getBall());
      assertFalse(result.getCorrect());
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException exception) {
      exception.printStackTrace();
    }
  }
}