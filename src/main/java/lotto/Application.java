package lotto;

import lotto.AppConfig.AppConfig;
import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        GameController controller = appConfig.gameController();
        controller.startLotto();
    }
}
