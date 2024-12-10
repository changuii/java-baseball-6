package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String NUMBERS_DELIMITER = "";
    private static final String ANSWER_YES = "1";

    public List<Integer> parseNumbers(final String input) {
        return Arrays.stream(input.split(NUMBERS_DELIMITER))
                .map(this::parseInt)
                .collect(Collectors.toList());
    }

    public boolean parseAnswer(final String input){
        return input.equals(ANSWER_YES);
    }

    private int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
