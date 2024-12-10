package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.component.BaseballGameGenerator;
import baseball.component.GameNumbersGenerator;
import baseball.mock.MockGameNumberGenerator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BaseballGameTest {

    private final MockGameNumberGenerator mockGameNumberGenerator;
    private final BaseballGameGenerator baseballGameGenerator;

    public BaseballGameTest(){
        this.mockGameNumberGenerator = new MockGameNumberGenerator();
        this.baseballGameGenerator = new BaseballGameGenerator(mockGameNumberGenerator);
    }

    private static Stream<Arguments> provideComputerNumbersAndUserNumbers(){
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 0, 3),
                Arguments.of(List.of(1, 2, 3), List.of(2, 3, 4), 2, 0),
                Arguments.of(List.of(1, 2, 3), List.of(3, 4, 5), 1, 0),
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 6), 0, 0),
                Arguments.of(List.of(1, 2, 3), List.of(1, 3, 2), 2, 1)
        );
    }

    @DisplayName("play() 메서드를 통해, 숫자를 비교했을 때 올바른 결과가 나오는지 테스트")
    @ParameterizedTest
    @MethodSource(value = "provideComputerNumbersAndUserNumbers")
    void play(final List<Integer> computer, final List<Integer> user, final int ballCount, final int strikeCount){
        // given
        mockGameNumberGenerator.setNextNumbers(computer);
        BaseballGame baseballGame = baseballGameGenerator.generate();
        BaseballResult expected = BaseballResult.of(ballCount, strikeCount);

        // when
        BaseballResult actual = baseballGame.play(user);

        // then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

}
