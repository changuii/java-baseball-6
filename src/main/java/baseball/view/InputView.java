package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public InputView(final InputValidator inputValidator, final InputParser inputParser) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }

    public List<Integer> readNumbers() {
        String input = Console.readLine();
        inputValidator.validateInputNumbers(input);
        List<Integer> numbers = inputParser.parseNumbers(input);
        inputValidator.validateNumbers(numbers);
        return numbers;
    }


}
