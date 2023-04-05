package org.example;

import java.util.HashMap;

public class Rq {
    private final String actionCode;
    private final HashMap<String, String> params;

    Rq(String command){
        String[] commandBits = command.split("\\?", 2);
        // String 배열을 통해 "삭제?id=1(번호)와 같은 명령어를 처리하려고 함
        // 배열의 길이가 2가 넘지 않도록 limit을 걸어둔거임
        // 물음표(?)를 기준으로 {삭제, id=1}
        actionCode = commandBits[0]; // "command 값"를 명령어로 받음 ex)삭제, 등록, 목록 등
        params = new HashMap<>(); // String 값 두 개를 받는 HaspMap 생성
        if(commandBits.length == 1)return;
        String[] paramBits = commandBits[1].split("&");
        for (String paramStr : paramBits) {
            String[] paramStrBits = paramStr.split("=", 2);
            String key = paramStrBits[0];
            String value = paramStrBits[1];
            params.put(key, value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParams(String name) {
        return params.get(name); // name이라는 키 값을 가진 값을 리턴
    }

    public int getIntparam(String name, int defaultValue){
        return Integer.parseInt(getParams(name)); // 현재 string으로 선언되어있는 value값을 int형변환해서 리턴
    }
}
