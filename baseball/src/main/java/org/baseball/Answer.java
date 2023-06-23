package org.baseball;

public class Answer {
  private final int ball;
  private final int strike;
  private final boolean result;

  private Answer(int ball, int strike, boolean result) {
    this.ball = ball;
    this.strike = strike;
    this.result = result;
  }

  public static Answer of(int ball, int strike) {
    if (strike == 3) {
      return new Answer(ball, strike, true);
    }
    return new Answer(ball, strike, false);
  }

  @Override
  public String toString() {
    if (strike == 3) { return "모두 맞췄습니다!!"; }
    if (ball == 0 & strike == 0) { return "낫띵"; }
    if (ball == 0) { return strike + " 스트라이크"; }
    if (strike == 0) { return ball + " 볼"; }

    return strike + " 스트라이크 " + ball + " 볼";
  }

  public int getBall() {
    return ball;
  }

  public int getStrike() {
    return strike;
  }

  public boolean getResult() {
    return result;
  }
}
