package org.baseball;

import java.util.Scanner;

public class Game {

  private final String RUNGAME = "1";
  private final String ENDGAME = "2";

  public Game() {

  }

  public void start() {
    String doGame;
    Computer computer = new Computer();
    computer.calculateAnswer();

    System.out.println(computer.getAnswer());
    Player player = new Player();

    while(true) {
      Answer answer = computer.checkAnswer(player.inputAnswer());
      System.out.println(answer.toString());
      if (answer.getResult()) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        doGame = scanner.next();

        validateOneOrTwo(doGame);

        break;
      }
    }
    if (doGame.equals(RUNGAME)) {
      start();
    }
  }
  private void validateOneOrTwo(String doGame) {
    if(!doGame.equals(RUNGAME) & !doGame.equals(ENDGAME)) {
      throw new IllegalArgumentException();
    }
  }
}
