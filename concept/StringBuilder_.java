package concept;

import java.io.IOException;

public class StringBuilder_ {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // StringBuilder 객체 생성

        sb.append("Hello");
        sb.append("World");

        String result = sb.toString(); // StringBuilder 객체를 String으로 변환

        System.out.println(result);


    }

}
