package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String NUMBERS_DELIMITER = "";

    public List<Integer> parseNumbers(final String input) {
        return Arrays.stream(input.split(NUMBERS_DELIMITER))
                .map(this::parseInt)
                .collect(Collectors.toList());
    }

    public int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
