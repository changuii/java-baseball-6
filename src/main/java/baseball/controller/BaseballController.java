package baseball.controller;

import baseball.component.BaseballGameGenerator;
import baseball.domain.BaseballGame;
import baseball.handler.RetryHandler;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RetryHandler retryHandler;
    private final BaseballGameGenerator baseballGameGenerator;

    public BaseballController(final InputView inputView, final OutputView outputView, final RetryHandler retryHandler,
                              final BaseballGameGenerator baseballGameGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryHandler = retryHandler;
        this.baseballGameGenerator = baseballGameGenerator;
    }

    public void run() {
        retryHandler.retryUntilAnswerYes(this::gameStart, this::isCompletedGame);
    }

    private boolean isCompletedGame() {
        outputView.printGameMenu();
        boolean answer = inputView.readAnswer();
        return answer;
    }

    private void gameStart() {
        outputView.printGameStart();
        BaseballGame baseballGame = baseballGameGenerator.generate();
    }

}
