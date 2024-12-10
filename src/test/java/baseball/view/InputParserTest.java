package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    private final InputParser inputParser;

    public InputParserTest() {
        inputParser = new InputParser();
    }


    private static Stream<Arguments> provideNumbersAndExpected() {
        return Stream.of(
                Arguments.of("123", List.of(1, 2, 3)),
                Arguments.of("456", List.of(4, 5, 6)),
                Arguments.of("789", List.of(7, 8, 9)),
                Arguments.of("189", List.of(1, 8, 9))
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumbersAndExpected")
    void 숫자_리스트_파싱_테스트(final String input, final List<Integer> expected) {
        List<Integer> actual = inputParser.parseNumbers(input);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    void 숫자_1을_입력하면_true_아니라면_false로_파싱한다(final String input, final boolean expected) {
        boolean actual = inputParser.parseAnswer(input);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12,", "346:", "1[45y5", "qqq"})
    void 숫자_리스트에_숫자가아닌_다른문자가_포함되면_예외가_발생한다(final String input) {
        assertThatThrownBy(() -> {
            inputParser.parseNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
