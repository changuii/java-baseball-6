package baseball.domain;

import java.util.List;

public class BaseballGame {
    private final List<Integer> numbers;

    private BaseballGame(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static BaseballGame from(final List<Integer> numbers) {
        return new BaseballGame(numbers);
    }
}
