package org.example;

import org.example.systemcontroller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;
import java.util.HashMap;

public class App {
        public void run() {
        System.out.println("===명언 앱===");
        WiseSayingController wiseSayingController = new WiseSayingController();
        while (true) {
            System.out.println("명령)");
            String command = Container.getSc().nextLine();
            if (command.equals("등록")) {
                wiseSayingController.write();
            } else if (command.equals("목록")) {
                wiseSayingController.list();
            } else if (command.equals("종료")) {
                SystemController.exit();
                break;
            } else if (command.startsWith("삭제")) {
                String[] commandBits = command.split("\\?", 2);
                // String 배열을 통해 "삭제?id=1(번호)와 같은 명령어를 처리하려고 함
                // 배열의 길이가 2가 넘지 않도록 limit을 걸어둔거임
                // 물음표(?)를 기준으로 {삭제, id=1}
                String actionCode = commandBits[0]; // "삭제"를 명령어로 받음
                HashMap<String, String> params = new HashMap<>(); // String 값 두 개를 받는 HaspMap 생성
                String[] paramBits = commandBits[1].split("&");
                for (String paramStr : paramBits) {
                    String[] paramStrBits = paramStr.split("=", 2);
                    String key = paramStrBits[0];
                    String value = paramStrBits[1];

                    params.put(key, value);
                }
                System.out.println(actionCode);
                System.out.println(params);
            }
        }
    }
}
