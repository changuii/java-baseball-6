package baseball.view;

import baseball.enums.OutputMessage;

public class OutputView {
    public void printBall(final int ballCount) {
        print(OutputMessage.BASEBALL_BALL, ballCount);
    }

    public void printStrike(final int strikeCount) {
        print(OutputMessage.BASEBALL_STRIKE, strikeCount);
    }

    public void printNothing() {
        print(OutputMessage.BASEBALL_NOTHING);
    }

    private void print(Object message, Object... values) {
        System.out.println(String.format(message.toString(), values));
    }
}
