package org.baseball;

public class Result {
  private final int ball;
  private final int strike;
  private final boolean isCorrect;

  private Result(int ball, int strike, boolean isCorrect) {
    this.ball = ball;
    this.strike = strike;
    this.isCorrect = isCorrect;
  }

  public static Result of(int ball, int strike) {
    if (strike == 3) {
      return new Result(ball, strike, true);
    }
    return new Result(ball, strike, false);
  }

  @Override
  public String toString() {
    if (ball == 0 & strike == 0) { return "낫띵"; }
    if (ball == 0) { return strike + " 스트라이크"; }
    if (strike == 0) { return ball + " 볼"; }

    return ball + " 볼" + strike + " 스트라이크 ";
  }

  public int getBall() {
    return ball;
  }

  public int getStrike() {
    return strike;
  }

  public boolean getCorrect() {
    return isCorrect;
  }
}
