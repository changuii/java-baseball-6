package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


public class BaseballResultTest {


    private static Stream<BaseballResult> provideBaseballResult() {
        return Stream.of(
                BaseballResult.of(0, 3),
                BaseballResult.of(1, 2),
                BaseballResult.of(2, 1),
                BaseballResult.of(3, 0),
                BaseballResult.of(2, 0),
                BaseballResult.of(1, 0),
                BaseballResult.of(0, 0),
                BaseballResult.of(0, 1),
                BaseballResult.of(0, 2),
                BaseballResult.of(0, 3)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1:true", "0:2:true", "0:3:true", "1:0:false", "2:0:false", "3:0:false"}, delimiter = ':')
    void 스트라이크_카운트_존재_여부_테스트(final int ballCount, final int strikeCount, final boolean expected) {
        BaseballResult baseballResult = BaseballResult.of(ballCount, strikeCount);

        boolean actual = baseballResult.hasStrikeCount();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0:true", "2:0:true", "3:0:true", "0:1:false", "0:2:false", "0:3:false"}, delimiter = ':')
    void 볼_카운트_존재_여부_테스트(final int ballCount, final int strikeCount, final boolean expected) {
        BaseballResult baseballResult = BaseballResult.of(ballCount, strikeCount);

        boolean actual = baseballResult.hasBallCount();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0:false", "2:0:false", "3:0:false", "0:1:false", "0:2:false", "0:3:false",
            "0:0:true"}, delimiter = ':')
    void 낫띵인지_여부_테스트(final int ballCount, final int strikeCount, final boolean expected){
        BaseballResult baseballResult = BaseballResult.of(ballCount, strikeCount);

        boolean actual = baseballResult.isNothing();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0:false", "2:0:false", "3:0:false", "0:1:false", "0:2:false", "0:3:true"}, delimiter = ':')
    void 정답인지_여부_테스트(final int ballCount, final int strikeCount, final boolean expected){
        BaseballResult baseballResult = BaseballResult.of(ballCount, strikeCount);

        boolean actual = baseballResult.isCorrect();

        assertThat(actual).isEqualTo(expected);
    }
}
