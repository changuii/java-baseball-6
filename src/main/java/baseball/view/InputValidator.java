package baseball.view;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private static final String NUMBERS_PATTERN_REGEX = "^[0-9]{3}$";
    private static final Pattern NUMBERS_PATTERN = Pattern.compile(NUMBERS_PATTERN_REGEX);

    public void validateInputNumbers(final String inputNumbers) {
        if (!NUMBERS_PATTERN.matcher(inputNumbers).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumbers(final List<Integer> numbers) {
        validateNumbersDuplication(numbers);
    }

    private void validateNumbersDuplication(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

}
