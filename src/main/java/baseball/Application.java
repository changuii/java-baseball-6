package baseball;

import baseball.config.BaseballConfig;
import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        BaseballController controller = BaseballConfig.createBaseballController();
        controller.run();
    }
}
