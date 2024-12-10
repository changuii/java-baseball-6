package baseball.handler;

import java.util.function.BooleanSupplier;

public class RetryHandler {

    public void retryUntilAnswerYes(Runnable logic, BooleanSupplier flag) {
        do {
            logic.run();
        } while (flag.getAsBoolean());
    }
}
