package baseball.view;

import baseball.enums.OutputMessage;

public class OutputView {

    public void printGameStart() {
        print(OutputMessage.GAME_START);
    }

    public void printBall(final int ballCount) {
        print(OutputMessage.BASEBALL_BALL, ballCount);
    }

    public void printStrike(final int strikeCount) {
        print(OutputMessage.BASEBALL_STRIKE, strikeCount);
    }

    public void printNothing() {
        print(OutputMessage.BASEBALL_NOTHING);
    }

    public void printGameEnd() {
        print(OutputMessage.GAME_END);
    }

    public void printGameMenu() {
        print(OutputMessage.GAME_MENU);
    }

    public void printLineBreak() {
        print(System.lineSeparator());
    }

    private void print(Object message, Object... values) {
        System.out.println(String.format(message.toString(), values));
    }
}
