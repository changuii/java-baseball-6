package baseball.mock;

import baseball.component.GameNumbersGenerator;
import java.util.List;

public class MockGameNumberGenerator implements GameNumbersGenerator {

    private List<Integer> numbers;

    @Override
    public List<Integer> generate() {
        return this.numbers;
    }

    public void setNextNumbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }
}

