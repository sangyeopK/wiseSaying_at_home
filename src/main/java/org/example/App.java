package org.example;

import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    private final Scanner sc;

    App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("===명언 앱===");
        int num = 0;

        ArrayList<WiseSaying> wiseSayings = new ArrayList<>();
        while (true) {
            System.out.println("명령)");
            String command = sc.nextLine();
            if (command.equals("등록")) {
                num++;
                int id = num;
                System.out.println("명언을 등록하세요");
                String content = sc.nextLine();
                System.out.println(content);
                System.out.println("작가를 등록하세요");
                String authorName = sc.nextLine();
                System.out.println(authorName);
                System.out.println(num + "번 명언이 등록 되었습니다");
                WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
                wiseSayings.add(wiseSaying);
            } else if (command.equals("종료")) {
                System.out.println("시스템을 종료합니다");
                break;
            } else if (command.equals("목록")) {
                System.out.println("생성된 명언 수 : " + num);
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-".repeat(30));
                for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                    WiseSaying wiseSaying = wiseSayings.get(i);  //wiseSaying 이라는 배열변수에 배열에 i값 넣기
                    System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthorName());
                }
            } else if (command.startsWith("삭제")) {
                String[] commandBits = command.split("\\?", 2);
                // String 배열을 통해 "삭제?id=1(번호)와 같은 명령어를 처리하려고 함
                // 배열의 길이가 2가 넘지 않도록 limit을 걸어둔거임
                // 물음표(?)를 기준으로 {삭제, id=1}
                String actionCode = commandBits[0]; // "삭제"를 명령어로 받음
                HashMap<String, String> params = new HashMap<>(); // String 값 두 개를 받는 HaspMap 생성
                String[] paramBits = commandBits[1].split("&");
                for(String paramStr : paramBits){
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
