package org.baseball;

public class Main {

  public static void main(String[] args) {
    Computer computer = new Computer();
    computer.calcAnswer();

    Player player = new Player();

    while(true) {
      Answer answer = computer.checkAnswer(player.inputAnswer());
      System.out.println(answer.toString());
      if (answer.getResult()) {
        System.out.println("3개의 숫자를 모두 맞추셨습니다!");
        break;
      }
    }
  }
}