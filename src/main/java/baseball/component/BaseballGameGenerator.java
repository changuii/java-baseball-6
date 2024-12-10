package baseball.component;

import baseball.domain.BaseballGame;

public class BaseballGameGenerator {

    private final GameNumbersGenerator gameNumbersGenerator;

    public BaseballGameGenerator(final GameNumbersGenerator gameNumbersGenerator) {
        this.gameNumbersGenerator = gameNumbersGenerator;
    }

    public BaseballGame generate() {
        return BaseballGame.from(gameNumbersGenerator.generate());
    }
}
