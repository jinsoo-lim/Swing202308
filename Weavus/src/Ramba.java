import java.util.Arrays;

public class Ramba {
    public static void main(String[] args) {

        String[] strings = {"1", "12", "123"};

        // 배열을 문자열 길이에 따라 정렬합니다.
        Arrays.sort(strings, (a, b) -> a.length() - b.length());
//      Arrays.sort(strings, (a, b) -> b.length() - a.length());

        // 정렬된 배열의 내용을 출력합니다.
        for (String str : strings) {
            System.out.println(str);
        }
    }
}