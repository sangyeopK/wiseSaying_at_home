package org.example.wiseSaying.entity;

public class WiseSaying {
// 명언의 목록을 출력해주기 위해 선언한 변수와 클래스 및 메소드
    private final String authorName;
    private final String content;
    private final int id;

    WiseSaying(int id, String content, String authorName) {
        this.id = id;
        this.content = content;
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getContent() {
        return content;
    }
}
