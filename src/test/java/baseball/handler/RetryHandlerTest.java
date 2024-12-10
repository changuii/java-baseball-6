package baseball.handler;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RetryHandlerTest {

    private static final int FLAG_BOUNDARY = 5;
    private static final int GARBAGE = 0;
    private final RetryHandler retryHandler;
    private int count = 0;

    public RetryHandlerTest() {
        this.retryHandler = new RetryHandler();
    }

    @BeforeEach
    void initCount() {
        count = 0;
    }

    @Test
    void 반환값과_매개변수가없는_로직에_flag가_true일때까지_반복하는_테스트() {
        retryHandler.retryUntilFalse(this::mockRunnable, this::trueUntilCountBoundary);

        assertThat(count).isEqualTo(FLAG_BOUNDARY);
    }

    @Test
    void 반환값과_매개변수가_있는_로직의_결과가_true일때까지_반복하는_테스트() {
        retryHandler.retryUntilTrue(this::mockFunction, GARBAGE);

        assertThat(count).isEqualTo(FLAG_BOUNDARY);
    }

    private void mockRunnable() {
        count++;
    }

    private boolean mockFunction(final int garbage) {
        count++;
        if (FLAG_BOUNDARY > count) {
            return false;
        }
        return true;
    }

    private Boolean trueUntilCountBoundary() {
        if (FLAG_BOUNDARY > count) {
            return true;
        }
        return false;
    }


}
