package baseball.config;

import baseball.controller.BaseballController;
import baseball.handler.RetryHandler;
import baseball.view.InputParser;
import baseball.view.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public abstract class BaseballConfig {

    public static BaseballController createBaseballController() {
        return new BaseballController(createInputView(), new OutputView(), new RetryHandler());
    }

    private static InputView createInputView() {
        return new InputView(new InputValidator(), new InputParser());
    }
}
