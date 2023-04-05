package org.example;

import org.example.systemcontroller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

public class App {
    public void run() {
        System.out.println("===명언 앱===");
        WiseSayingController wiseSayingController = new WiseSayingController();
        while (true) {
            System.out.println("명령)");
            String command = Container.getSc().nextLine();
            Rq rq = new Rq(command);
            if (rq.getActionCode().equals("등록")) {
                wiseSayingController.write();
            } else if (rq.getActionCode().equals("목록")) {
                wiseSayingController.list();
            } else if (rq.getActionCode().equals("종료")) {
                SystemController.exit();
                break;
            } else if (rq.getActionCode().startsWith("삭제")) {
                wiseSayingController.remove(rq);
            }
        }
    }
}
