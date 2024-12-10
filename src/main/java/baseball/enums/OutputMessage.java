package baseball.enums;

public enum OutputMessage {
    INTRODUCE_USER_INPUT("숫자를 입력해주세요 : "),

    BASEBALL_NOTHING("낫싱"),
    BASEBALL_BALL("%d볼 "),
    BASEBALL_STRIKE("%d스트라이크"),

    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_MENU("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");


    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
