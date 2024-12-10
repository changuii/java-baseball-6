package baseball.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    private final InputValidator inputValidator;

    public InputValidatorTest() {
        this.inputValidator = new InputValidator();
    }


    @ParameterizedTest
    @ValueSource(strings = {"1234", "12345", "123456", "12345678"})
    void 입력값의_형태가_숫자3개가_아니라면_예외가_발생한다(final String input) {
        assertThatThrownBy(() -> {
            inputValidator.validateInputNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1-2", "-12", "34-", ";;;", "1-2-3"})
    void 입력값에_숫자가_아닌_문자가_포함되어있다면_예외가_발생한다(final String input) {
        assertThatThrownBy(() -> {
            inputValidator.validateInputNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> provideDuplicateNumbers() {
        return Stream.of(
                List.of(1, 1, 2),
                List.of(1, 1, 1),
                List.of(9, 9, 9),
                List.of(9, 5, 9),
                List.of(5, 9, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateNumbers")
    void 입력_리스트에_숫자가_중복되어있다면_예외가_발생한다(final List<Integer> numbers) {
        assertThatThrownBy(() -> {
            inputValidator.validateNumbers(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdasdad", "wrewerewr", "k", "K", "Q", "Z", "3", "Y", "N"})
    void 사용자_응답에_1혹은2가_아닌값이_포함되어있다면_예외가_발생한다(final String input) {
        assertThatThrownBy(() -> {
            inputValidator.validateInputAnswer(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "196", "392"})
    void 입력_숫자_문자열이_올바른값이라면_예외가_발생하지_않는다(final String input) {
        inputValidator.validateInputNumbers(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 사용자_응답이_1혹은2_라면_예외가_발생하지_않는다(final String input) {
        inputValidator.validateInputAnswer(input);
    }

}
