package baseball.enums;

public enum OutputMessage {

    BASEBALL_NOTHING("낫싱"),
    BASEBALL_BALL("%d볼 "),
    BASEBALL_STRIKE("%d스트라이크");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
