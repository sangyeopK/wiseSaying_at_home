package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;

public class WiseSayingController {
    ArrayList<WiseSaying> wiseSayings = new ArrayList<>();
    int num = 0;

    public void write() {
            num++;
            int id = num;
            System.out.println("명언을 등록하세요");
            String content = Container.getSc().nextLine();
            System.out.println(content);
            System.out.println("작가를 등록하세요");
            String authorName = Container.getSc().nextLine();
            System.out.println(authorName);
            System.out.println(num + "번 명언이 등록 되었습니다");
            WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
            wiseSayings.add(wiseSaying);
    }

    public void list() {
        System.out.println("생성된 명언 수 : " + num);
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);  //wiseSaying 이라는 배열변수에 배열에 i값 넣기
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthorName());
        }
    }
}
