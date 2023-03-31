package org.example;

import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
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
            }
        }
    }
}
