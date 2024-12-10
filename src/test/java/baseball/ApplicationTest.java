package baseball;

import baseball.enums.OutputMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private static final String FORMAT_REGEX = "%d";

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 출력_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("345", "234", "312", "132", "456", "123", "2");
            assertThat(output()).contains(provideOutputMessage());
        }, 1, 2, 3);
    }

    @Test
    void 컴퓨터가_수를_생성하는_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("123", "2");
            assertThat(output()).contains(OutputMessage.GAME_END.toString());
        }, 1, 2, 3);
    }

    @ParameterizedTest
    @CsvSource(value = {"312:3", "215:2", "692:1"}, delimiter = ':')
    void 사용자의_수와_컴퓨터의_수를_정확히_비교해서_볼_개수를_출력하는가(final String input, final int ballCount) {
        assertRandomNumberInRangeTest(() -> {
            run(input, "123", "2");
            assertThat(output())
                    .contains(String.format(OutputMessage.BASEBALL_BALL.toString(), ballCount));

        }, 1, 2, 3);
    }

    @ParameterizedTest
    @CsvSource(value = {"124:2", "145:1"}, delimiter = ':')
    void 사용자의_수와_컴퓨터의_수를_정확히_비교해서_스트라이크_개수를_출력하는가(final String input, final int strikeCount) {
        assertRandomNumberInRangeTest(() -> {
            run(input, "123", "2");
            assertThat(output())
                    .contains(String.format(OutputMessage.BASEBALL_STRIKE.toString(), strikeCount));

        }, 1, 2, 3);
    }

    @Test
    void 사용자의_수에_컴퓨터의_수가_없다면_낫띵을_출력하는가() {
        assertRandomNumberInRangeTest(() -> {
            run("456", "123", "2");
            assertThat(output()).contains(OutputMessage.BASEBALL_NOTHING.toString());
        }, 1, 2, 3);
    }

    @Test
    void 사용자의_수가_정답이라면_3스트라이크와_정답을_출력하는가() {
        assertRandomNumberInRangeTest(() -> {
            run("123", "2");
            assertThat(output())
                    .contains(String.format(OutputMessage.BASEBALL_STRIKE.toString(), 3))
                    .contains(OutputMessage.GAME_END.toString());
        }, 1, 2, 3);
    }

    private List<String> provideOutputMessage() {
        return List.of(
                OutputMessage.INTRODUCE_USER_INPUT.toString(),
                OutputMessage.BASEBALL_NOTHING.toString(),
                OutputMessage.BASEBALL_BALL.toString().replaceAll(FORMAT_REGEX, ""),
                OutputMessage.BASEBALL_STRIKE.toString().replaceAll(FORMAT_REGEX, ""),
                OutputMessage.GAME_START.toString(),
                OutputMessage.GAME_END.toString(),
                OutputMessage.GAME_MENU.toString()
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
