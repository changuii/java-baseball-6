package baseball.controller;

import baseball.component.BaseballGameGenerator;
import baseball.domain.BaseballGame;
import baseball.domain.BaseballResult;
import baseball.handler.RetryHandler;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

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
        retryHandler.retryUntilTrue(this::gameStart, this::isCompletedGame);
    }

    private boolean isCompletedGame() {
        outputView.printGameMenu();
        boolean answer = inputView.readAnswer();
        return answer;
    }

    private void gameStart() {
        outputView.printGameStart();
        BaseballGame baseballGame = baseballGameGenerator.generate();
        retryHandler.retryUntilTrue(this::gamePlay, baseballGame);
        outputView.printGameEnd();
    }


    private Boolean gamePlay(final BaseballGame baseballGame) {
        outputView.printIntroduceUserInput();
        List<Integer> userNumbers = inputView.readNumbers();
        BaseballResult baseballResult = baseballGame.play(userNumbers);
        outputResult(baseballResult);
        return baseballResult.isCorrect();
    }

    private void outputResult(final BaseballResult baseballResult) {
        if (baseballResult.hasBallCount()) {
            outputView.printBall(baseballResult.getBallCount());
        }
        if (baseballResult.hasStrikeCount()) {
            outputView.printStrike(baseballResult.getStrikeCount());
        }
        if (baseballResult.isNothing()) {
            outputView.printNothing();
        }
        outputView.printLineBreak();
    }

}
