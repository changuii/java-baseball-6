package baseball.domain;

public class BaseballResult {
    private final int ballCount;
    private final int strikeCount;

    private BaseballResult(final int ballCount, final int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static BaseballResult of(final int ballCount, final int strikeCount) {
        return new BaseballResult(ballCount, strikeCount);
    }


}
