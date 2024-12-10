package baseball.domain;

import java.util.List;

public class BaseballGame {
    private static final int NUMBERS_COUNT = 3;
    private final List<Integer> numbers;

    private BaseballGame(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static BaseballGame from(final List<Integer> numbers) {
        return new BaseballGame(numbers);
    }

    public BaseballResult play(final List<Integer> userNumbers) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < NUMBERS_COUNT; i++) {
            int nowNumber = userNumbers.get(i);
            if (isStrike(i, nowNumber)) {
                strikeCount++;
            } else if (isBall(i, nowNumber)) {
                ballCount++;
            }
        }
        return BaseballResult.of(ballCount, strikeCount);
    }

    private boolean isStrike(final int location, final int number) {
        if (numbers.get(location) == number) {
            return true;
        }
        return false;
    }

    private boolean isBall(final int location, final int number) {
        if (numbers.get(location) != number && numbers.contains(number)) {
            return true;
        }
        return false;
    }
}
