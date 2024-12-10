package baseball.component;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BaseballGame;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BaseballGameGeneatorTest {
    private BaseballGameGenerator baseballGameGenerator;
    private MockGameNumberGenerator gameNumbersGenerator;


    public BaseballGameGeneatorTest(){
        gameNumbersGenerator = new MockGameNumberGenerator();
        baseballGameGenerator = new BaseballGameGenerator(gameNumbersGenerator);
    }

    private static Stream<List<Integer>> provideRandomNumbers() {
        return Stream.of(
                List.of(1, 2, 3),
                List.of(10, 20, 30),
                List.of(50, 100, 120)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "provideRandomNumbers")
    void 주어진_랜덤값으로_게임이_생성되는지_테스트(final List<Integer> numbers) {
        // given
        gameNumbersGenerator.setNextNumbers(numbers);

        // when
        BaseballGame baseballGame = baseballGameGenerator.generate();

        // then
        assertThat(baseballGame).extracting("numbers").isEqualTo(numbers);

    }


    private class MockGameNumberGenerator implements GameNumbersGenerator {

        private List<Integer> numbers;

        @Override
        public List<Integer> generate() {
            return this.numbers;
        }

        public void setNextNumbers(final List<Integer> numbers) {
            this.numbers = numbers;
        }
    }
}
