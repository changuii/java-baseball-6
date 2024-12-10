package baseball.handler;

import java.util.function.BooleanSupplier;
import java.util.function.Function;

public class RetryHandler {

    public void retryUntilTrue(final Runnable logic, final BooleanSupplier flag) {
        do {
            logic.run();
        } while (flag.getAsBoolean());
    }

    public <T> void retryUntilTrue(final Function<T, Boolean> logic, final T data) {
        while (!logic.apply(data)) {
        }
    }

}
