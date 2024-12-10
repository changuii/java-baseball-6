package baseball.domain;

public class BaseballResult {
    private static final int CORRECT_COUNT = 3;
    private static final int ZERO = 0;
    private final int ballCount;
    private final int strikeCount;

    private BaseballResult(final int ballCount, final int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static BaseballResult of(final int ballCount, final int strikeCount) {
        return new BaseballResult(ballCount, strikeCount);
    }

    public boolean isCorrect() {
        return strikeCount == CORRECT_COUNT;
    }

    public boolean isNothing() {
        return strikeCount + ballCount == ZERO;
    }

    public boolean hasBallCount() {
        return ballCount > ZERO;
    }

    public boolean hasStrikeCount() {
        return strikeCount > ZERO;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
