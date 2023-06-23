package org.baseball;

public class Main {

  public static void main(String[] args) {
    Computer computer = new Computer();
    computer.calcAnswer();

    Player player = new Player();
    Answer answer = computer.checkAnswer(player.inputAnswer());
    System.out.println(answer.toString());
  }
}