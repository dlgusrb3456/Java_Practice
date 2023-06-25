package org.baseball;

import java.util.Scanner;

public class Game {

  private final String RUNGAME = "1";
  private final String ENDGAME = "2";

  public Game() {
  }

  public void start() {
    Computer computer = new Computer();
    Player player = new Player();

    String doGame = RUNGAME;

    while (doGame.equals(RUNGAME)) {
      computer.calculateAnswer();
      doGame = run(computer, player, new Scanner(System.in));
    }
  }

  private String run(Computer computer, Player player, Scanner scanner) {
    while (true) {
      player.inputAnswer(scanner);
      Result result = computer.checkAnswer(player.getPlayerInput());
      System.out.println(result.toString());

      if (result.getCorrect()) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String doGame = scanner.next();

        validateOneOrTwo(doGame);
        return doGame;
      }
    }
  }

  private void validateOneOrTwo(String doGame) {
    if (!doGame.equals(RUNGAME) & !doGame.equals(ENDGAME)) {
      throw new IllegalArgumentException();
    }
  }
}
